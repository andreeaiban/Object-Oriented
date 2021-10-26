import javax.swing.JOptionPane;
/*
 * @author: Andreea Ibanescu
 * @date: Feb/16/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * The Project0.java program implements an application using the JOptionPane class
 * that asks the user to input a setence, then using the user the program will find
 * the amount of times the character "E" & "e" are used. The amount is output on the screen.
 * The program will not end until users enters "STOP".
 */
public class Project0
{
  
   public static void main(String[]arg)
   {
    
     //the program will run in a loop until instructed to shut up
     while(true){
      
     //User information stored in the input
     String input=  JOptionPane.showInputDialog("Please enter a sentence.");
     
      //this if-statement allows the user to stop the while loop  by stopping the program
     if(input.contentEquals("STOP"))
      System.exit(0);  
    
     //Primitive Variables 
     int len= input.length();
     int upcase=0, lowcase=0;
     
     /*This for loop will examine each letter in the input string and count the times letter 'E' appears and stores in the upcase int variable
     * Also how many times the lower-case letter 'e' appears then stores the value in lowcase int variable. */
    
     for(int i=0; i<len; i++)
     {
         if( input.charAt(i)=='e')
             lowcase++;
         if(input.charAt(i)=='E')
             upcase++;        
     }
     //Uses JOptionPane class to display the values of upcase and lowcase 
     JOptionPane.showMessageDialog(null,"Number of Upper case e's: "+ upcase +"\n Number of Lower Case e's: "+lowcase);
                }
  
   }
}
   