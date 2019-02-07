 /*
  * This department treat of question 
  */
package mmn13_a;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Questions extends JPanel  {
 

/**
 *
 * @author Elisheva Shmuel
 */

  
   private final int answer;// the good answer
   private int usrAns;// answer use 
   private final  JRadioButton q1,q2,q3,q4;// of chose answer question
   private final  Label txt;// question(how mach?...)
   private final JLabel correct , worng; //0f correct answer or worng
   
    
     
    public Questions(String s0,String s1,String s2,String s3,String s4,int ans)
    {
 
         answer=ans;
         System.out.println("ans="+answer);
         txt=new  Label (s0);
         q1=new JRadioButton(s1);
         q2=new JRadioButton(s2);    
         q3=new JRadioButton(s3); 
         q4=new JRadioButton(s4); 
         correct=new JLabel("corect");
         worng=new JLabel("worng");
         worng.setVisible(false);
         correct.setVisible(false);
         q1.addActionListener(new ButtonAction() );
         q2.addActionListener(new ButtonAction() );
         q3.addActionListener(new ButtonAction() );
         q4.addActionListener(new ButtonAction() );
         add(new TestDraw(),BorderLayout.CENTER );
       
    
   }
 
 
       private class TestDraw extends JPanel
       {
          public TestDraw()
          {
              setLayout(new GridLayout(7,1,1,1));
               ButtonGroup bg=new ButtonGroup();
                 bg.add(q1);bg.add(q2);bg.add(q3); bg.add(q4);
                  add(txt);
                  add(q1);
                  add(q2);
                  add(q3);    
                  add(q4);
                  add(correct);
                  add(worng);
                 
                  
        }
       }
    /**
     * This method check if the  good answer and the use answer are equalse.
     * @return true if equalse, else false  
     */      
     public boolean checkAnswer()
     {
        if (usrAns==answer)
            return true;
       return false;
                 
     
     }
     
     
     /**
      * This method return JLabel correct
      * @return JLabel correct 
      */
     public JLabel getCorect()
     {
         return correct;
     }
     
     
     
     /**
      * This method return JLabel worng
      * @return JLabel worng
      */
     public JLabel getWorng()
     {
         return worng;
     }
     
    
    //  this method Taking care of the event of JRadioButton
    private class ButtonAction implements ActionListener
       {
          public void actionPerformed(ActionEvent event)
          {
      
             Object e=event.getSource();
     
            if(e.equals(q1))
                usrAns=1;
            else if(e.equals(q2))
                 usrAns=2;
            else if(e.equals(q3))
                 usrAns=3; 
            else if(e.equals(q4))
                 usrAns=4;
     
          }
       } 
    

}

        
    

