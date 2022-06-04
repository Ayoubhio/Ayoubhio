package Informations;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.jsoup.Connection.Base;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class inscription {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	public inscription() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 663);
		panel.setBackground(new Color(46,123,166));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Job");
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(88, 452, 246, 47);
		lblNewLabel.setForeground(new Color (166, 168, 162));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Les \u00E9tudes\\INFO\\CI ENSAK\\S7\\Java\\Projet\\pictures\\Jobs_1620245837.jpg"));
		lblNewLabel_1.setBounds(26, 216, 349, 225);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setDoubleBuffered(false);
		panel_1.setBounds(398, 0, 438, 663);
		panel_1.setBackground(new Color(143,190,217));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Second_name");
		lblNewLabel_2.setForeground(new Color (81, 94, 54));
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(40, 94, 104, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(40, 110, 308, 20);
		textField.setBackground(new Color(143,190,217));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 132, 308, 2);
		separator.setBackground(new Color (81, 94, 54));
		panel_1.add(separator);
		
		JLabel lblNewLabel_2_1 = new JLabel("First_name");
		lblNewLabel_2_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(40, 152, 104, 14);
		panel_1.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(143, 190, 217));
		textField_1.setBounds(40, 168, 308, 20);
		panel_1.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(81, 94, 54));
		separator_1.setBounds(40, 190, 308, 2);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(40, 210, 47, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(143, 190, 217));
		textField_2.setBounds(40, 226, 308, 20);
		panel_1.add(textField_2);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(new Color(81, 94, 54));
		separator_1_1.setBounds(40, 248, 308, 2);
		panel_1.add(separator_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Domain");
		lblNewLabel_2_1_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(40, 340, 70, 14);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox.setForeground(new Color (81, 94, 54));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"computer science", "electric","data engineering", "mechatronic", "industrial", "Process management"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(40, 365, 135, 22);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Sex");
		lblNewLabel_2_1_1_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1.setBounds(40, 398, 70, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Masculin", "Feminin"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setForeground(new Color(81, 94, 54));
		comboBox_1.setBounds(40, 423, 135, 22);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Password");
		lblNewLabel_2_1_1_1_2.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_2.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_2.setBounds(40, 267, 94, 14);
		panel_1.add(lblNewLabel_2_1_1_1_2);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(40, 286, 308, 20);
		passwordField.setBackground(new Color(143,190,217));
		panel_1.add(passwordField);
		
		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBackground(new Color(81, 94, 54));
		separator_1_1_2.setBounds(40, 306, 308, 2);
		panel_1.add(separator_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Stu/Lor");
		lblNewLabel_2_1_1_1_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_1.setBounds(40, 456, 70, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Student", "Loreat"}));
		comboBox_1_1.setToolTipText("");
		comboBox_1_1.setForeground(new Color(81, 94, 54));
		comboBox_1_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox_1_1.setBounds(40, 474, 135, 22);
		panel_1.add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBorder(new LineBorder(new Color(46, 123, 166), 5, true));
		btnNewButton.setBackground(new Color(143,190,217));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
		    {
				 based bs = new based();
				try
				{
                String nom =  textField.getText();
            	String prenom = textField_1.getText();
            	String email = textField_2.getText();
            	String pass = String.valueOf(passwordField.getText());
            	String domain = (String) comboBox.getSelectedItem();
            	String sex = (String) comboBox_1.getSelectedItem();
            	String type = (String) comboBox_1_1.getSelectedItem();
            	EmailValidator emailValidator = new EmailValidator();
            	
                 if(nom.equals("") || prenom.equals("") || email.equals("") || pass.equals(""))
                {
                	 JOptionPane.showMessageDialog(frame,"Please fill in all the boxes");
                }
                 else
                 {
                	 if(!emailValidator.validate(email.trim()))
                	 {
                		 JOptionPane.showMessageDialog(frame,"Email syntax is not accepcted example of email : nom12@gmail.com");
                	 }
                	 else
                	 {
                		 bs.connexion();
                		 bs.insert_arg(nom,prenom,email,domain,type,sex,pass);
 						JOptionPane.showMessageDialog(frame," You are succesufully registred in data_base");
 						textField.setText("");
 						textField_1.setText("");
 						textField_2.setText("");
 						passwordField.setText("");
 						login inser= new login();  
 		        		frame.setVisible(false);
 		        		inser.main(new String[]{});
                	 }
                 }
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(135, 525, 156, 35);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon("D:\\Les \u00E9tudes\\INFO\\CI ENSAK\\S7\\Java\\Projet\\pictures\\cv_50x50.png"));
		lblNewLabel_2_2.setBounds(188, 11, 65, 66);
		panel_1.add(lblNewLabel_2_2);
		
		
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inscription window = new inscription();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
