package project;

import javax.swing.*;
/**
 * 
 * @author Abdallah Al-Sulaihat
 *
 */
public class Frame extends JFrame
{
    public Frame()
    {
        setTitle("Employee Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel newpanel = new Panel();
        getContentPane().add(newpanel);
    }
    
    public static void main(String[] args)
    {
        JFrame frame = new Frame();
        frame.pack();
        frame.setVisible(true);
    }
}
