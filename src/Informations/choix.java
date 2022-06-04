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
import javax.swing.SwingConstants;

public class choix 
{
	private JFrame frame;
	public choix() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Please choose the desired page :");
		lblNewLabel_2.setForeground(new Color (81, 94, 54));
		lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(40, 94, 331, 14);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBorder(new LineBorder(new Color(46, 123, 166), 5, true));
		btnNewButton.setBackground(new Color(143,190,217));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
		    {
				try
				{
					consulter inser= new consulter();  
	        		frame.setVisible(false);
	        		inser.main(new String[]{});
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(272, 268, 156, 35);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon("D:\\Les \u00E9tudes\\INFO\\CI ENSAK\\S7\\Java\\Projet\\pictures\\cv_50x50.png"));
		lblNewLabel_2_2.setBounds(188, 11, 65, 66);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Predict Your type of contract : ");
		lblNewLabel_2_1.setToolTipText("");
		lblNewLabel_2_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 199, 266, 35);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("     Display the offers according  \r\n");
		lblNewLabel_2_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 264, 266, 35);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("to your type of contract and the city : ");
		lblNewLabel_2_1_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(10, 280, 266, 35);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JButton btnPredict = new JButton("PREDICTE");
		btnPredict.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnPredict.setBorder(new LineBorder(new Color(46, 123, 166), 5, true));
		btnPredict.setBackground(new Color(143, 190, 217));
		btnPredict.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
		    {
				try
				{
					Predict inser= new Predict();  
	        		frame.setVisible(false);
	        		inser.main(new String[]{});
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnPredict.setBounds(272, 200, 156, 35);
		panel_1.add(btnPredict);
		
		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBackground(new Color(81, 94, 54));
		separator_1_1_2.setBounds(10, 228, 249, 2);
		panel_1.add(separator_1_1_2);
		
		JSeparator separator_1_1_2_1 = new JSeparator();
		separator_1_1_2_1.setBackground(new Color(81, 94, 54));
		separator_1_1_2_1.setBounds(10, 310, 256, 6);
		panel_1.add(separator_1_1_2_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("     Change Password");
		lblNewLabel_2_1_1_2.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_2.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_2.setBounds(10, 341, 266, 35);
		panel_1.add(lblNewLabel_2_1_1_2);
		
		JSeparator separator_1_1_2_1_1 = new JSeparator();
		separator_1_1_2_1_1.setBackground(new Color(81, 94, 54));
		separator_1_1_2_1_1.setBounds(10, 373, 256, 6);
		panel_1.add(separator_1_1_2_1_1);
		
		JButton btnChange = new JButton("CHANGE");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					changer_mdp inser= new changer_mdp();  
	        		frame.setVisible(false);
	        		inser.main(new String[]{});
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnChange.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnChange.setBorder(new LineBorder(new Color(46, 123, 166), 5, true));
		btnChange.setBackground(new Color(143, 190, 217));
		btnChange.setBounds(272, 341, 156, 35);
		panel_1.add(btnChange);
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choix window = new choix();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
