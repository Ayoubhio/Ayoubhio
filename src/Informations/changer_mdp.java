package Informations;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
//import com.mysql.cj.jdbc.Driver;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
import javax.swing.border.EmptyBorder;

public class changer_mdp {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public changer_mdp() 
	{
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
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Old Password");
		lblNewLabel_2_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(40, 170, 108, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(new Color(143, 190, 217));
		passwordField_1.setBounds(40, 195, 308, 20);
		panel_1.add(passwordField_1);
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(new Color(81, 94, 54));
		separator_1_1.setBounds(40, 218, 308, 2);
		panel_1.add(separator_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("New Password");
		lblNewLabel_2_1_1_1_2.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_2.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_2.setBounds(40, 232, 108, 14);
		panel_1.add(lblNewLabel_2_1_1_1_2);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(40, 249, 308, 20);
		passwordField.setBackground(new Color(143,190,217));
		panel_1.add(passwordField);
		
		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBackground(new Color(81, 94, 54));
		separator_1_1_2.setBounds(40, 272, 308, 2);
		panel_1.add(separator_1_1_2);
		
		JButton btnNewButton = new JButton("Update");
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
            	String old_pass = String.valueOf(passwordField_1.getText());
            	String new_pass = String.valueOf(passwordField.getText());
                 if(old_pass.equals("") || new_pass.equals(""))
                {
                	 JOptionPane.showMessageDialog(frame,"Please fill in all the boxes");
                }
                 else
                 {
                		Connection cnx = null;
         				Statement stm=null;
         				ResultSet result =null;
         				String url = "jdbc:mysql://localhost:3306/project"  ;
         				String user = "root";
         				String passwd = "";
         				Class c =Class.forName("com.mysql.cj.jdbc.Driver");
         		        Driver pilote = (Driver)c.getDeclaredConstructor().newInstance();
         		        DriverManager.registerDriver(pilote);
         		        cnx = DriverManager.getConnection(url,user,passwd);
         		        String req = "SELECT * FROM etudiant WHERE password = '"+old_pass+"'";
         		        String req1= " UPDATE etudiant SET password = '"+new_pass+"' WHERE password = '"+old_pass+"'";
         		        stm = cnx.createStatement();
         				result = stm.executeQuery(req);
         				if(result.next())
        				{				
         					String nom = result.getString("nom");
         					String prenom = result.getString("prenom");
         					String pass = result.getString("password");
         					Statement stm1 = cnx.createStatement();
             				var result1 = stm1.executeUpdate(req1);
        				    JOptionPane.showMessageDialog(frame,"password is changed to  " +nom+ " "+prenom);
        				    choix inser= new choix();  
        	        		frame.setVisible(false);
        	        		inser.main(new String[]{});
        				}   
         				else
         				{
         					JOptionPane.showMessageDialog(frame,"there is no student or loreat with this password");
         				}
                 }
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(117, 346, 156, 35);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Les \u00E9tudes\\INFO\\CI ENSAK\\S7\\Java\\Projet\\pictures\\cv_50x50.png"));
		lblNewLabel_2.setBounds(183, 49, 65, 66);
		panel_1.add(lblNewLabel_2);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changer_mdp window = new changer_mdp();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
