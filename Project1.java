import java.util.*;
/**
 * @author: Andreea Ibanescu
 * @date: March/10/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * The Project1.java program reads the string info from the file "Project1.txt", then it will create Clocks and store them into two arrays. 
 * One will get sorted and the other will remain the same as on the text file. Then both arrays will be displayed on a GUI.
 * Any info printed onto the system was invalid format of 00:00:00 (didn't contain all three: hour , sec , min).
 */
public class Project1
{
   public static TextFileInput myFile;
   public static StringTokenizer myTokens;
   
   public static String line;
   public static int count=0;
   
   public static void main(String[]arg) {
    
   //Two empty Clock arrays of the length of 14 
    Clock[] array1 = new Clock[15];
    Clock[] array2 = new Clock[15];
    
   //Stores the file needed for the project into a TextFileInput called myFile
    myFile = new TextFileInput("Project1.txt");
   
   //This loop gpes through the 16 lines in the "Project1.txt". Then, creates tokens for the string parts that are Hours, mins, and secs.
    for(int i=0; i<16; i++){
      
      line = myFile.readLine(); 
      myTokens = new StringTokenizer(line,":");
      
      if(myTokens.countTokens()==3)
        {
         int hourT = Integer.parseInt(myTokens.nextToken());
         int minT=  Integer.parseInt(myTokens.nextToken());
         int secT= Integer.parseInt(myTokens.nextToken());
         Clock current= new Clock(hourT,minT,secT);
         count++;
         array1[count]= current;
         array2[count]= current;
        }
      else 
        {
            System.out.println(line);
        }
      } 
    //The method selectionSort is applied to array1 
      selectionSort(array1);
      
    //The method ClockGUICreate is applied to array1 and array2. The method is located in the ClockGUI.java class. The method a GUI, which displays the sorted array and the unsorted array of clocks.
        //ClockGUI.ClockGUICreate(array1, array2);
    }
   /**
    * This method compares Clock "one" to Clock "two". Then, returns true if Clock "one" has a time value (hr,min,sec) less than Clock "two".
    * @param Clock one
    * @param Clock two
    * @return boolean 
    */
   public static boolean compare(Clock one, Clock two)
   {
      
       //Gets hour,min, and sec from Clock one and Clock two and stores it to compare later
       
       int xhr= one.getHour();
       int yhr= two.getHour();
       int xmin= one.getMin();
       int ymin= two.getMin();
       int xsec= one.getSec();
       int ysec= two.getSec();
       
       //Compares by hour then min and ast it will check seconds.  
       if(xhr==yhr)
       {
           if(xmin==ymin)
           {
               return xsec<ysec;
           }
           return xmin<ymin;
       }
       else 
           return xhr<yhr;
  
   }
   /**
    * This method takes the parameter array and uses selection sort,which makes the Clocks in "Arr"[] in order from the least amount to greatest amount of hours.
    * @param An array of Clocks, named "arr"[].
    */
   public static void selectionSort(Clock arr[])
   {
       int minIndex, len;
       len=arr.length;
       
       for(int i=1; i<len; i++)
       {
         minIndex=i;
         for(int j=i; j<len; j++)
         {
         //Uses the compare method, if returns true: it makes the Clock at pos j with Clock at pos min index:
       
          if(compare(arr[j],arr[minIndex]))
              minIndex=j;
         }
         //swap the min element into the first element, a "temp" Clock is created so that values of clock being replaced isn't lost during the process.
         Clock temp= arr[minIndex];
         arr[minIndex]=arr[i];
         arr[i]=temp;
       }
           
   }
}

    