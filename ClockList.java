/**
 * @author: Andreea Ibanescu
 * @date: April/4/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * The ClockList.java program  has a ClockList constructor and an append method that adds a clock to the ClockList for the 
 * Project2.java file.
 */

public class ClockList{
//Instance variables
    ClockNode first;
    ClockNode last;
    int length;
  
//constructor
  public ClockList(){
      ClockNode time= new ClockNode();
      first=time;
      last=time;
      length=0;
  }
  /**
    * This method adds Clock "C" to the ClockList
    * @param Clock "c"
    */
   public void append(Clock c){
       ClockNode n=new ClockNode(c);
       last.next=n;
       last=n;
       length++;
   } 
}
