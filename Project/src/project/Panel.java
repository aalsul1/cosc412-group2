package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Class for setting up the Log-in GUI
 * @author Abdallah Al-Sulaihat
 *
 */
public class Panel extends JPanel
{
        private JButton loginButton;        
	private JLabel employeeIdLabel, employeePassLabel, errorLabel, welcomeLabel; 
	private JTextField employeeIdField;
        private JPasswordField employeePassField;
        private JPanel homePanel, empLabels, empFields, id;
        private final int WIDTH = 500, HEIGHT = 600;
	
	public Panel()
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	        
		employeeIdLabel = new JLabel("Employee ID");
		employeeIdField = new JTextField(10);
                employeePassLabel = new JLabel("Password");
                employeePassField = new JPasswordField(10);
                errorLabel = new JLabel("Username/Password incorrect. Please try again");
                errorLabel.setForeground(Color.RED);
                errorLabel.setVisible(false);
                
                JPanel emptyPanel = new JPanel();
                emptyPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
                
                
		empLabels = new JPanel();
		empLabels.add(employeeIdLabel);
                empLabels.add(employeePassLabel);
                empLabels.setPreferredSize(new Dimension(70, 50));
                
                empFields = new JPanel();
                empFields.add(employeeIdField);
                empFields.add(employeePassField);
                empFields.setPreferredSize(new Dimension(150, 50));
                
                loginButton = new JButton("Login");
                loginButton.addActionListener(new ButtonListener());
                
                id = new JPanel();
                id.setBorder(new TitledBorder(new EtchedBorder(), "Please log in"));
                id.setPreferredSize(new Dimension(350, 140));
                id.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
                id.add(empLabels);
                id.add(empFields);
                id.add(loginButton);
                id.add(errorLabel);
                
                homePanel = new JPanel();
                homePanel.setPreferredSize(new Dimension(450, 550));
                welcomeLabel = new JLabel();
                homePanel.add(welcomeLabel);
                welcomeLabel.setVisible(false);
                add(emptyPanel);
                add(id);
                add(homePanel);
	}
        
        private class ButtonListener implements ActionListener {
            
		public void actionPerformed(ActionEvent e) {
                    Object source = e.getSource();
                    if(source == loginButton) {
                        //retrieving info typed in fields
                        String employeeId = employeeIdField.getText();
                        String password = employeePassField.getText();
                        
                        //validate employeeId and password
                        //get info on mysql database and compare username and password
                        //get type of employee also
                        boolean correct = false;                        
                        
                        //placeholders...
                        if(employeeId.equals("admin") && password.equals("99wwe"))
                            correct = true;
                        
                        if(!correct) {
                            errorLabel.setVisible(true);
                        }
                        else {
                            errorLabel.setForeground(Color.GREEN);
                            errorLabel.setText("Login successful, please wait...");
                            
                            //look up type of employee....
                            //get a value from database, create an instance of that type of employee
                            
                            //placeholder, holds value dictating type of employee
                            int retrievedId = 0;
                            Employee emp;
                            
                            //create instance of that type of employee
                            if (retrievedId == 0) emp = new Manager();
                            else if (retrievedId == 1) emp = new Admin();
                            else if (retrievedId == 2) emp = new Auditor();
                            else if (retrievedId == 3) emp = new Trainee();
                            else
                                emp = null;
                            
                            //homePanel.setPreferredSize(new Dimension(500, 600));
                            id.setVisible(false);
                            welcomeLabel = new JLabel("Welcome, " + emp.getFirstName() + " " + emp.getLastName());
                            homePanel.add(welcomeLabel);
                            welcomeLabel.setVisible(true);
                                                                                                                          
                            //create instance of homepage specific to that employee type
                            
                        }
                    }
                }
        }
}
