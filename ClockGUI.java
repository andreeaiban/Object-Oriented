import java.awt.GridLayout;
import javax.swing.*; 
/**
 * @author: Andreea Ibanescu
 * @date: March/10/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * The ClockGUI.java program has a constructor 
 */

public class ClockGUI extends JFrame
{
    UnsortedClockList one;
    SortedClockList two;
    /**
     * This method uses two ClockList of Clocks and creates a GUI that displays two ClockLists. In this case it will display a sorted list of ClocksNodes than a unsorted ClocksList of ClockNodes.
     * @param String title 
     * @param  int height 
     * @param int width 
     */
    
    public ClockGUI(String title,int height, int width ){
        setTitle(title);
        setSize(height,width);
        setLocation  (200,200);
        CreateFileMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    //This method was used to make a GUI for Project2
     public void TwoClockGUI(UnsortedClockList unsort, SortedClockList sort) {
        
        //Setup for the GUI display
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Clock GUI Grid");
        frame.setSize(100,100);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Creating the layout format based on the length of the list
        int len= unsort.length; 
        frame.setLayout(new GridLayout(len, 2));
        
        //starting the loop with the pointer at the first Node in the List
        ClockNode unsortNCur=unsort.first;
        ClockNode sortNCur=sort.first;
        
        //loop to go through the two linked lists by moving the pointer in order to display by creating two lables and adding them to the GUI frame display.
        while(unsortNCur.next!=null && sortNCur.next!=null )
        {
            unsortNCur=unsortNCur.next;
            JLabel list1= new JLabel(unsortNCur.data+"  ");
            frame.getContentPane().add(list1);
            
            sortNCur=sortNCur.next;
            JLabel list2= new JLabel(sortNCur.data+"  ");
            frame.getContentPane().add(list2);
        }   
        //Display to the GUI window
        frame.pack();
        frame.setVisible(true);
    }
     
    // This method uses creates a FileMenu GUI that is used for the ClockGUI & Project3. 
    public void CreateFileMenu(){
                JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
                JMenu editMenu= new JMenu("Edit");
                
                //this creates a new FileMenuHandler which allows for methods in class FileMenuHandler to get used
		FileMenuHandler fmh = new FileMenuHandler(this);
                EditMenuHandler emh= new EditMenuHandler(this);
                
                item= new JMenuItem("Search"); 
                item.addActionListener(emh);
                editMenu.add(item);
                
		item = new JMenuItem("Open"); // Open...
		item.addActionListener(fmh);
		fileMenu.add(item);
                
		fileMenu.addSeparator();
                
		item = new JMenuItem("Quit"); // Quit
		item.addActionListener(fmh);
		fileMenu.add(item);
                
                setJMenuBar(menuBar);
		menuBar.add(fileMenu);
                menuBar.add(editMenu);
    }
}