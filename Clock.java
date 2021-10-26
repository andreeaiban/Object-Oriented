/*
 * @author: Andreea Ibanescu
 * @date: March/10/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * This class program Clock.java is used for Project2.java to create a Clock object and its contents. 
 */
public class Clock
{
   private int hour,min,sec;
   
  /**
   * Creates a Clock with the specified hour, minute, and second. If any of the params are invalid an new IllegalClockException is thrown
   * @param h The hour of the clock
   * @param m The minutes of the clock
   * @param s The seconds of the clock
   */
   public Clock(int h, int m, int s){
       if(h>=24 || h<0)
           throw new IllegalClockException();
       hour=h;
       if(m>=60 || m<0)
           throw new IllegalClockException();
       min=m;
       if(s>=60 || s<0)
           throw new IllegalClockException();
       sec=s;
   }
   /**
    * Gets the hour of the clock.
    * @return an int that represents the Clock's hour.
    */
   public int getHour(){
       return hour;
   }
   /**
    * Gets the minutes the clock.
    * @return an int that represents the Clock's minutes. 
    */
   public int getMin(){
       return min;
   }
   /**
    * Gets the seconds of the clock.
    * @return an int that represents the Clock's seconds.
    */
   public int getSec(){
       return sec;
   }
   /**
    * Sets the Clock's hour.
    * @param newHour an int containing a hour for the Clock.
    */
   public void setHour(int newHour){
       this.hour=newHour;
   }
   /**
    * Sets the Clock's minutes.
    * @param newMin an int containing mins for the Clock.
    */
   public void setMin(int newMin) {
       this.min=newMin;
   }
   /**
    * Sets the Clock's seconds.
    * @param newSec an int containing secs for the Clock.
    */
   public void setSec(int newSec){
       this.sec=newSec;
   }
   /**
    * This method overrides the toString method to be proper to display Clock time in "00:00:00" format.
    * @return String 
    */
   public String toString(){
       String output="";
       if(hour==0)
          output=output+"00:";
       else  if(hour<10 && hour>0 )
           output=output+"0"+hour+":";
       else
           output=output+hour+":";
       if(min==0)
           output=output+"00:";
       else  if(min<10 && min>0)
           output=output+"0"+min+":";
       else
           output=output+min+":";
       
       if(sec==0)
           output=output+"00";
       else  if(sec<10 && sec>0)
           output=output+"0"+sec;
       else
           output=output+sec;
                    
        return output;
        
   }
}