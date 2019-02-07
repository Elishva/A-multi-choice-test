/*
 * This department taking care of test check and give marks.
 */
package mmn13_a;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 *
 * @author Elisheva Shmuel
 */
public class Test extends JPanel
{
    private final ArrayList <Questions> t=new ArrayList();// of question.
    Questions q1;
    private  Button btn ; // of button finish the test. 
    private JLabel result;// the mark of the test.
    
    public Test() throws FileNotFoundException
    {
         Scanner input ;
         String st;
         int c=0;
         Random  rnd=new  Random();
         int r;
         final int LINE=4;
         Questions t1;
         
         
         ArrayList <String> s1= new ArrayList(); 
         ArrayList <String> s2= new ArrayList(); 
         
         //found the file of exam
         String nameFile=Paths.get(".").toAbsolutePath().normalize().toString()+"\\src\\mmn13_a\\exam.txt";
        //opean and read question
        input = new Scanner(new File(nameFile));
        while (input.hasNextLine())
        {
              st = input.nextLine();
             
              s1.add(st);
              if (c==LINE)
              {  
                 s2.add(s1.get(0));
                 s1.remove(0);
                 int ans=0;
                 boolean flag=true;
                 for (int i=0;i<LINE;i++)
                 {
                    r=rnd.nextInt(LINE-i); 
                    if ((r==0) && (flag))
                     {
                        ans=s2.size();
                        flag=false;
                     }
                    s2.add(s1.get(r)); 
                    s1.remove(r);
                 }
                
            
             //create question
             t1 =new Questions(s2.get(0),s2.get(1),s2.get(2),s2.get(3),s2.get(4),ans);
             t.add(t1);// add question
             s1.clear();
             s2.clear();
             c=-1;
             }
             c++;
           
          
              
         }
          
        input.close();
        
        //add the question to panel.
        setLayout(new BorderLayout());
        add(new ButDraw(),BorderLayout.CENTER);  
    }
  
    
    /**
     * This method return get of Question
     * @param i- index of question.
     * @return get of Question 
     */
     public Questions getQuestion(int i)
    {
      return t.get(i);
    }
  
   /**
    * This method return the size of t
    * @return   the size of t
    */
    public int length()
    {
        return t.size();
    }
    
    // this auxiliary  method to check the test 
    private void checkTest()
     {
         int count=0;
         for(int i=0;i<t.size();i++)
         { // if the answer is correct
             if(t.get(i).checkAnswer())
             {
                  t.get(i).getCorect().setVisible(true);// set Visbile correct becausethe answer is correct 
                  count++;// increase the number of good answer

             }
             else
                  t.get(i).getWorng().setVisible(true);//set Visbile worng becausethe answer is correct 
         }
         result.setText(Math.round(count*100.0/t.size())+"%");//calculate the mark of test.
         result.setVisible(true);// set visble of mark.
     }
    
    
   
    // this method drawand add the button of finish and JLabel of result to panel 
    private class ButDraw extends JPanel
       {
          public ButDraw()
          {
               // add the button finish
                btn=new Button("FINISH");
                add(btn);
               
                btn.addActionListener(new ButtonAction());
                // add the result- the result of test.
                result=new JLabel("result");
                result.setVisible(false);
                 add(result);
                  
         }  
          
      }
    
    
    //this method Taking care of the event of finish. 
    private class ButtonAction implements ActionListener
       {
            public void actionPerformed(ActionEvent ae)
            {
               Object e=ae.getSource();
               if(e==btn)
                  checkTest();
            }
       } 
   
}

