package Informations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.SwingConstants;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.jdbc.Driver;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Dimension;

public class consulter 
{
    Connection cnx = null;
	private JFrame frame;
	private JTable table;
	ResultSet rs = null;
	PreparedStatement preparedStmt = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	JComboBox comboBox_1;
	JComboBox comboBox;

	public consulter()
	{
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1379, 839);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(85, 107, 47));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					selectTable();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnTlchargerPdf = new JButton("PDF");
		btnTlchargerPdf.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnTlchargerPdf.setForeground(new Color(85, 107, 47));
		btnTlchargerPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Document doc = new Document();
				String query = "SELECT * FROM offre";
		
				try {
					
     				String url = "jdbc:mysql://localhost:3306/project"  ;
     				String user = "root";
     				String passwd = "";
     				Class c =Class.forName("com.mysql.cj.jdbc.Driver");
     		        Driver pilote = (Driver)c.getDeclaredConstructor().newInstance();
     		        DriverManager.registerDriver(pilote);
     		        cnx = DriverManager.getConnection(url,user,passwd);

					PreparedStatement prepared = cnx.prepareStatement(query);
			 		rs = prepared.executeQuery();
					PdfWriter.getInstance(doc, new FileOutputStream("D:\\Les études\\INFO\\CI ENSAK\\S7\\Java\\Projet\\pdf"));
					doc.open();
					
//					Image img = Image.getInstance("D:\\PROJETS\\MINI-PROJET JAVA\\1.jpg");
//					img.scaleAbsoluteWidth(600);
//					img.scaleAbsoluteHeight(92);
//					img.setAlignment(Image.ALIGN_CENTER);
//					doc.add(img);
					
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph("Offres disponibles :"));
					doc.add(new Paragraph(" "));
					PdfPTable table = new PdfPTable(6);
					table.setWidthPercentage(100);
					
					PdfPCell cell;
					
					////////////////////////////////////////////////////////////////////////////////////////////////
					cell = new PdfPCell(new Phrase("Entreprise",FontFactory.getFont("Comic Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell.setBackgroundColor(BaseColor.GRAY);
			    	table.addCell(cell);
					
			    	cell = new PdfPCell(new Phrase("Missions",FontFactory.getFont("Comic Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell.setBackgroundColor(BaseColor.GRAY);
			    	table.addCell(cell);
			    	
			    	cell = new PdfPCell(new Phrase("Profil",FontFactory.getFont("Comic Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell.setBackgroundColor(BaseColor.GRAY);
			    	table.addCell(cell);
			    	
			    	cell = new PdfPCell(new Phrase("Secteur",FontFactory.getFont("Comic Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell.setBackgroundColor(BaseColor.GRAY);
			    	table.addCell(cell);
			    	
			    	cell = new PdfPCell(new Phrase("Type de contrat",FontFactory.getFont("Comic Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell.setBackgroundColor(BaseColor.GRAY);
			    	table.addCell(cell);
			    	
			    	cell = new PdfPCell(new Phrase("Ann�e d'experience",FontFactory.getFont("Comic Sans MS",12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell.setBackgroundColor(BaseColor.GRAY);
			    	table.addCell(cell);
			    	///////////////////////////////////////////////////////////////////////////////////////////////
					while(rs.next())
					{
				    	cell = new PdfPCell(new Phrase(rs.getString("entreprise").toString(),FontFactory.getFont("Arial",11)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(rs.getString("missions").toString(),FontFactory.getFont("Arial",11)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(rs.getString("profil").toString(),FontFactory.getFont("Arial",11)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);				    
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(rs.getString("secteur").toString(),FontFactory.getFont("Arial",11)));
					    cell.setHorizontalAlignment(Element.ALIGN_CENTER);				    	
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(rs.getString("TypeContrat").toString(),FontFactory.getFont("Arial",11)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);				    	
						table.addCell(cell);
						
						cell = new PdfPCell(new Phrase(rs.getString("niveauExperience").toString(),FontFactory.getFont("Arial",11)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(cell);
					}


					doc.add(table);
					
					doc.close();
					Desktop.getDesktop().open(new File("D:\\Les études\\INFO\\CI ENSAK\\S7\\Java\\Projet\\pdf"));
			
			
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (DocumentException e1) {
					
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBackground(new Color(85, 107, 47));
		separator_2_2.setBounds(10, 709, 248, 5);
		frame.getContentPane().add(separator_2_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBackground(new Color(85, 107, 47));
		separator_2_1.setBounds(10, 602, 248, 5);
		frame.getContentPane().add(separator_2_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(85, 107, 47));
		separator_2.setBounds(10, 493, 248, 5);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(85, 107, 47));
		separator.setBounds(10, 370, 248, 5);
		frame.getContentPane().add(separator);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox_1.setForeground(new Color (81, 94, 54));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bac", "Bac+1","Bac+2", "Bac+3", "Bac+4", "Bac+5 et plus"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(123, 135, 135, 22);
		frame.getContentPane().add(comboBox_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox.setForeground(new Color (81, 94, 54));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CDD", "CDI","CDD - Freelance", "CDI - CDD", "CDI - CDD - Freelance", "CDI - CDD - Freelance - Alternance","CDI - Freelance","CDI - Stage","Freelance","Int�rim","Stage","Statutaire"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(123, 94, 135, 22);
		frame.getContentPane().add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(143, 190, 217));
		textField_3.setBorder(null);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 656, 248, 48);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Activity area :");
		lblNewLabel_3_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1_1.setBounds(10, 618, 248, 31);
		lblNewLabel_3_1_1_1_1.setForeground(new Color(81, 94, 54));
		frame.getContentPane().add(lblNewLabel_3_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(143, 190, 217));
		textField_2.setColumns(10);
		textField_2.setBounds(10, 551, 248, 48);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Web Site :");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(10, 509, 248, 31);
		lblNewLabel_3_1_1_1.setForeground(new Color(81, 94, 54));
		frame.getContentPane().add(lblNewLabel_3_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(143, 190, 217));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 437, 248, 48);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Logo link :");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(10, 412, 238, 14);
		lblNewLabel_3_1_1.setForeground(new Color(81, 94, 54));
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setColumns(10);
		textField.setBackground(new Color(143, 190, 217));
		textField.setBounds(10, 316, 248, 48);
		frame.getContentPane().add(textField);
		
		
		
		JLabel lblNewLabel_3_1 = new JLabel("Full Company Name:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 291, 248, 14);
		lblNewLabel_3_1.setForeground(new Color(81, 94, 54));
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(new Color(166,168,162));
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBounds(0, 267, 272, 5);
		frame.getContentPane().add(lblNewLabel_6);
		btnTlchargerPdf.setFont(new Font("Eras Light ITC", Font.BOLD, 15));
		btnTlchargerPdf.setBounds(133, 227, 125, 20);
		frame.getContentPane().add(btnTlchargerPdf);
		btnNewButton.setFont(new Font("Eras Light ITC", Font.BOLD, 15));
		btnNewButton.setBounds(133, 182, 125, 20);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(282, 83, 1051, 642);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int ligne = table.getSelectedRow();
				String entreprise = table.getModel().getValueAt(ligne, 0).toString();
				String query = "SELECT * FROM entreprise WHERE title='"+entreprise+"'";
				try
				{
					String url = "jdbc:mysql://localhost:3306/project"  ;
     				String user = "root";
     				String passwd = "";
     				Class c =Class.forName("com.mysql.cj.jdbc.Driver");
     		        Driver pilote = (Driver)c.getDeclaredConstructor().newInstance();
     		        DriverManager.registerDriver(pilote);
     		        cnx = DriverManager.getConnection(url,user,passwd);

					preparedStmt = cnx.prepareStatement(query);
					rs = preparedStmt.executeQuery();
					if(rs.next())
					{
						textField.setText(rs.getString("title"));
						textField_1.setText(rs.getString("logo"));
						textField_2.setText(rs.getString("website"));
						textField_3.setText(rs.getString("secteur"));
					}
				}
				catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException se)
				{
					se.printStackTrace();
				}
			}
			
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBackground(new Color(166,168,162));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBounds(268, 67, 3, 682);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("LEVEL :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(0, 137, 113, 14);
		lblNewLabel_4.setForeground(new Color(81, 94, 54));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("T.CONTRACT :");
		lblNewLabel_3.setForeground(new Color(81, 94, 54));
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 96, 113, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("offer portal");
		lblNewLabel.setBackground(new Color(46, 123, 166));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(81, 94, 54));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1215, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(166,168,162));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 67, 1370, 5);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(143, 190, 217));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(-10, 67, 1370, 682);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Retour vers Choix");
		btnNewButton_1.setPreferredSize(new Dimension(135, 23));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				choix inser= new choix();  
        		frame.setVisible(false);
        		inser.main(new String[]{});
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBorder(new LineBorder(new Color(46, 123, 166), 5, true));
		btnNewButton_1.setBackground(new Color(143, 190, 217));
		btnNewButton_1.setBounds(1214, 4, 146, 61);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public void selectTable() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException
	{
		String niveau = comboBox_1.getSelectedItem().toString();
		String contrat = comboBox.getSelectedItem().toString();
			try 
			{
				String url = "jdbc:mysql://localhost:3306/project"  ;
 				String user = "root";
 				String passwd = "";
 				Class c =Class.forName("com.mysql.cj.jdbc.Driver");
 		        Driver pilote = (Driver)c.getDeclaredConstructor().newInstance();
 		        DriverManager.registerDriver(pilote);
 		        cnx = DriverManager.getConnection(url,user,passwd);

				String query = "SELECT entreprise,title,missions,profil,metier,region,ville,niveauExperience,langues,nombrePoste FROM offre WHERE niveauEtude = ? AND typeContrat = ? ";
				PreparedStatement preparedStmt = cnx.prepareStatement(query);
				preparedStmt.setString(1, niveau);
				preparedStmt.setString(2, contrat);
				ResultSet rs = preparedStmt.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consulter window = new consulter();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
