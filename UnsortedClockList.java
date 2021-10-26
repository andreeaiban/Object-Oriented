 /*
 * @author: Andreea Ibanescu
 * @date: March/10/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * This class program UnsortedClockList.java is used for Project2.java to create a unsorted linked list
 * of ClockNodes that are Clocks.
 */
class UnsortedClockList extends ClockList{
    
     public UnsortedClockList(){
         //Calls the ClockList's constructor 
        super(); 
     }
   /**
   * Calls the ClockList's append method.
   * @param Clock "C"
   */
     public void add(Clock c)
     {
       super.append(c);
     }
     
}