import java.util.StringTokenizer;
import java.io.*;
/**
 * @author: Andreea Ibanescu
 * @date: April/22/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * The Project3.java program reads the string info from the file and creates a GUI Clock Menu that lists sorted and unsorted clocks. To search for specific clock time, 
 * you have to search the file first otherwise it will crash.
 */

public class Project3{
    static ClockGUI cGUI;

    public static void main(String[]args) throws IOException{
        
        cGUI= new ClockGUI("Clock Menu GUI ",400,400);
        
    }
}