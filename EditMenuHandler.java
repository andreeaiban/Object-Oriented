/*
 * @author: Andreea Ibanescu
 * @date: May/9/2020
 * @lab section: B Hang Zheng
 * @csci 212 (2:45-3:35pm) 
 * This class program EditMenuHandler.java is used for Project3.java to create a EditMenuHandler file, that MUST be used once you search for the file FIRST. OTHERWISE, the program will crash.
 */

import javax.swing.*;
import java.awt.event.*;

public class EditMenuHandler implements ActionListener {

    ClockGUI cgui;

    public EditMenuHandler(ClockGUI c) {
        cgui = c;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Search")) {
            String hourStr = JOptionPane.showInputDialog("Enter an hour for a clock:");
            try {
                int hourNum = Integer.parseInt(hourStr);
                if (hourNum >= 0 && hourNum <= 23) {
// Display new GUI with hours at or below given value
                    FileMenuHandler fmh = new FileMenuHandler(cgui);
                    fmh.hourDisplay(hourNum);
                } else {
                    JOptionPane.showMessageDialog(null, "You did not enter a valid hour.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "You did not enter an integer.");
            }
        }
    } // actionPerformed
}
