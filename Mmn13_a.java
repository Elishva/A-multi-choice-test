
package mmn13_a;
 
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Elisheva Shmuel
 */
public class Mmn13_a {

   static Test tst;
    static  Button btnRestart = new Button("RESTART");
    static JFrame frame;
    static JPanel mainPanel;
    static JPanel pn1;// of question
    static JPanel pn2 ;// of button
    
    public static void main(String[] args) throws FileNotFoundException
    {
        // build frame
        frame= new JFrame("TEST");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        
        tst=new Test();
        pn2 = new JPanel();
        pn1 = new JPanel();
       
        
         // add ansewr to pn1     
         for(int i=0;i<tst.length();i++) 
            pn1.add(tst.getQuestion(i));
         
         
        // add label to pn2
        pn2.add(btnRestart);
        pn2.add(tst);
        btnRestart.addActionListener(new ButtonAction() );
        
       
       //Place the panels on the frame 
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(pn1,BorderLayout.CENTER);
        mainPanel.add(pn2,BorderLayout.SOUTH);
        
        
        frame.add(mainPanel);
        frame.setVisible(true);
        
    }
    
    
    // this method taking care of presenting the questionnaire again 
     private static void restart() throws FileNotFoundException
    {
        tst=new Test();
         
        // add the pan1 again
        pn1.removeAll();// clear the panel
        for(int i=0;i<tst.length();i++)// add again the question 
            pn1.add(tst.getQuestion(i));
        pn1.validate();
        pn1.repaint();
        
         // add the pan2 again
        pn2.removeAll();// clear the pane2
        pn2.add(btnRestart);// add again restart
        pn2.add(tst);//add the label.
        pn2.validate();
        pn2.repaint();
         
         
        
    }
     
     
     // this method Taking care of the event of restart
      private static class ButtonAction implements ActionListener
       {
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    Object e=ae.getSource();
                    if(e==btnRestart)
                        restart();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Mmn13_a.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
    }

   
    
   
}
