 /*
 * @author: Andreea Ibanescu
 * @date: April/10/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * This class program SortedClockList.java is used for Project2.java to create a Clock object and its contents. 
 */
class SortedClockList extends ClockList{
    //Instance Variable
     ClockNode curNode;
    //Constructor 
     public SortedClockList(){
        super(); 
     }
     
    /**
    * This method uses insertion sort to add a Clock into a ClockList of ClockNodes in order from least to greatest. 
    * @param Clock "c"
    */
     public void add(Clock c)
     {
       ClockNode preNode= first;
       ClockNode newNode= new ClockNode(c);
       ClockNode curNode= first.next;
      
       //loop to find the correct pointer location for Clock C
       while(curNode!=null && compare(curNode.data,newNode.data))
       {
         preNode=preNode.next;
         curNode=curNode.next;
         
       }
       //adds it to the correct place
        newNode.next=curNode;
        preNode.next=newNode;
        
        //if theres not location it adds it to the last
        if(curNode==null)
            last=newNode;
        length++;
        
     } 
    /**
    * This method compares Clock "one" to Clock "two". Then, returns true if Clock "one" has a time value (hr,min,sec) less than Clock "two".
    * @param Clock one
    * @param Clock two
    * @return boolean 
    */
     public static boolean compare(Clock one, Clock two)
     { 
        //true if clock one is less than two
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
}