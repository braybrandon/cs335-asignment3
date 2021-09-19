package com.company;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.MonthDay;

public class ChristmasButton extends JFrame
        implements ActionListener {

    private JButton button;
    private MonthDay christmas;

    // Constructor
    public ChristmasButton() {
        super("Hello, World of Buttons!");
        this.setSize(300,100);
        christmas = MonthDay.parse("--12-25");

        // get the content pane, onto which everything is eventually added
        Container c = getContentPane();

        // instantiate the JButton object
        button = new JButton("Is it Christmas?");

        // set up the Button:  add an event listener object
        button.addActionListener(this);
        button.setForeground(Color.RED);

        // Add button to the container
        c.add(button);

        // Make it all visible
        setVisible(true);
    }

    // override the "actionPerformed" method to customize...
    public void actionPerformed (ActionEvent e) {
        MonthDay today = MonthDay.now();
        if(today.compareTo(christmas) == 0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static void main(String args[])
    {
        // Instantiate this object, start the interface
        ChristmasButton B = new ChristmasButton();


        // This longer form overrides the windowClosing method
        // so that the program will exit when the window receives
        // a "windowClosing" event


        B.addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });
    }
}
