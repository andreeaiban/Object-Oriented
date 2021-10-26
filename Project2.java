import java.util.*;

import java.io.*;
 /**
 * @author: Andreea Ibanescu
 * @date: April/3/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * The Project2.java program reads the string info from the file "Project1.txt", 
 * then it will token the strings into ints of hr,min,sec. Using that it will make a Clock, then
 * make it into a ClockNode. After ClockNodes are created it will be put into a ClockLists. One will
 * be sorted then one will not be sorted.
 */
public class Project2{
     //Instance Variables
     public static StringTokenizer myTokens;
     public static String line;
     public static TextFileInput myFile;
     public static UnsortedClockList unsortedNodes;
     public static SortedClockList sortedNodes;
     
     public static void main(String[]args) throws IOException{ 
        
         
         //Creating UnsortedClockList and SortedClockList
         unsortedNodes= new UnsortedClockList();
         sortedNodes= new SortedClockList();
         
         //TextFile
         myFile = new TextFileInput("Project1.txt");
         
         //Loop for reading through the file & creating Clocks out of the String, then putting them in ClockLists
         for(int i=0; i<16; i++){
     
             line = myFile.readLine(); 
             myTokens = new StringTokenizer(line,":");
      
             if(myTokens.countTokens()==3)
             {
                 int hourT = Integer.parseInt(myTokens.nextToken());
                 int minT=  Integer.parseInt(myTokens.nextToken());
                 int secT= Integer.parseInt(myTokens.nextToken());
                 Clock current= new Clock(hourT,minT,secT);
                 unsortedNodes.add(current);
                 sortedNodes.add(current);
             }
             else
                 System.out.println(line);
             
         }
         //Displaying the unsorted & sorted ClockList of Nodes using the GUI
         //ClockGUI.ClockGUICreate(unsortedNodes, sortedNodes);
         
       
             
        // ClockGUI clockgui= new ClockGUI(unsortedNodes,sortedNodes);
         
     }
}
