/*
 * @author: Andreea Ibanescu
 * @date: May/9/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * This class program FileMenuHandler.java creates a fileMenu that reads clocks from a text file. Put them in lists and sorts them using a treemap.
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;



public class FileMenuHandler implements ActionListener {

    ClockGUI cgui;
    public static TextFileInput myFile;
    public static StringTokenizer myTokens;
    public static String hours, minutes, seconds;
    public static String line;
    public static int lineCount;
    public static UnsortedClockList unsortedL;
    public static SortedClockList sortedL;
    public static String chosenFileName;

    public FileMenuHandler(ClockGUI c) {
        cgui = c;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            openFile();
        } else if (menuName.equals("Quit")) {
            System.exit(0);
        }
    } //actionPerformed

    private void openFile() {
        JFileChooser chooser;
        int status;
        chooser = new JFileChooser();
        status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            readSource(chooser.getSelectedFile());
        } else {
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
        }
    } //openFile

    private void readSource(File chosenFile) {
// Calling GUI method
// Create and set up the window
        JFrame frame = new JFrame("Clock GUI");
        frame.setSize(550, 400);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Container cp = frame.getContentPane();

        TextArea left = new TextArea(); // unsorted
        TextArea right = new TextArea(); // sorted

        cp.add(left, BorderLayout.WEST); // unsorted
        cp.add(right, BorderLayout.EAST); // sorted

        left.setPreferredSize(new Dimension(500, 400));
        right.setPreferredSize(new Dimension(500, 400));

        chosenFileName = chosenFile.getAbsolutePath();
        myFile = new TextFileInput(chosenFileName);

        TreeMap<String, Integer> sortT = new TreeMap<>();

// Reading a line
        line = myFile.readLine();
        lineCount=0;

// Using a loop to iterate through each line of the file
        while (line != null) {
// Creating a new StringTokenizer to find the hours, minutes, and seconds
            myTokens = new StringTokenizer(line, ":");

// Checking the amount of tokens to see if I should print or store into list
            if (myTokens.countTokens() == 1) {
                System.out.println(myTokens.nextToken());
            } else if (myTokens.countTokens() == 2) {
                System.out.println(myTokens.nextToken() + ":" + myTokens.nextToken());
            } else {
                try {
                    hours = myTokens.nextToken();
                    minutes = myTokens.nextToken();
                    seconds = myTokens.nextToken();

// Tree map 
                    left.append(new Clock(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(seconds)).toString() + "\n");
                   
                    sortT.put(new Clock(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(seconds)).toString(), lineCount);
               
                    lineCount++;
                } catch (IllegalClockException ex) {
                    System.out.println(line);
                }
            }
            line = myFile.readLine();
        }

        Set set = sortT.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            right.append(me.getKey() + "\n");
            //for testing: System.out.println(me.getKey() + " -> " + me.getValue());
        }

// Display the window
        frame.pack();
        frame.setVisible(true);
    }

    public void hourDisplay(int h) {
// Calling GUI method
// Create and set up the window
        JFrame frame = new JFrame("Clock GUI");
        frame.setSize(550, 400);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Container cp = frame.getContentPane();

        TextArea left = new TextArea(); // unsorted
        TextArea right = new TextArea(); // sorted

        cp.add(left, BorderLayout.WEST); // unsorted
        cp.add(right, BorderLayout.EAST); // sorted

        left.setPreferredSize(new Dimension(500, 400));
        right.setPreferredSize(new Dimension(500, 400));

        myFile = new TextFileInput(chosenFileName);

        TreeMap<String, Integer> sortT = new TreeMap<>();

// Reading a line
        line = myFile.readLine();
        lineCount=0;

// Using a loop to iterate through each line of the file
        while (line != null) {
// Creating a new StringTokenizer to find the hours, minutes, and seconds
            myTokens = new StringTokenizer(line, ":");

// Checking the amount of tokens to see if I should print or store into list
            if (myTokens.countTokens() == 1) {
                System.out.println(myTokens.nextToken());
            } else if (myTokens.countTokens() == 2) {
                System.out.println(myTokens.nextToken() + ":" + myTokens.nextToken());
            } else {
                try {
                    hours = myTokens.nextToken();
                    minutes = myTokens.nextToken();
                    seconds = myTokens.nextToken();

// Tree map
                    if (Integer.parseInt(hours) <= h) {
                        left.append(new Clock(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(seconds)).toString() + "\n");
                        sortT.put(new Clock(Integer.parseInt(hours), Integer.parseInt(minutes), Integer.parseInt(seconds)).toString(), lineCount);
                        lineCount++;
                    }
                } catch (IllegalClockException ex) {
                    System.out.println(line);
                }
            }
            line = myFile.readLine();
        }

        Set set = sortT.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            right.append(me.getKey() + "\n");
           //for testing: System.out.println(me.getKey() + " -> " + me.getValue());
        }

// Display the window
        frame.pack();
        frame.setVisible(true);
    }
}
