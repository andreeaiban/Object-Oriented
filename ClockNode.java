/**
 * @author: Andreea Ibanescu
 * @date: April/4/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * The ClockNode.java program has constructors for the ClockNode objects that will be used for
 * Project2.java file.
 */
public class ClockNode{
    //Instance Variables
   protected Clock data;
   protected ClockNode next;
    
   /**
   * Creates a ClockNode with the specified data and next Node.
   * @param Clock "data" 
   * @param Clock "next" 
   */
   public ClockNode(Clock data, ClockNode next ){
       this.data=data;
       this.next=next;
   }
   //constructor with no params
   public ClockNode(){
       this.data=null;
       this.next=null;
   }
   /**
   * Creates a ClockNode with the specified data.
   * @param Clock "data" 
   */
   public ClockNode(Clock data){
       this.data=data;
       this.next=null;
   }
}