package Informations;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.cj.jdbc.Driver;

import machine.Classification;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

public class Predict 
{
	Classification cs = new Classification();
	private JFrame frame;

	public Predict() 
	{
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setDoubleBuffered(false);
		panel_1.setBounds(0, 0, 836, 663);
		panel_1.setBackground(new Color(143,190,217));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Please choose your options : ");
		lblNewLabel_2_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(25, 71, 263, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Les \u00E9tudes\\INFO\\CI ENSAK\\S7\\Java\\Projet\\pictures\\cv_50x50.png"));
		lblNewLabel_2.setBounds(383, 11, 65, 66);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(145, 493, 409, 47);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Snap ITC", Font.ITALIC, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setForeground(new Color(81, 94, 54));
		comboBox.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"HUTCHINSON","INTELCIA","LYCAMOBILE","DANBITEL","SMBH_SARL","JOB_PLUS","MUBAWAB","AFRICAWORK","OUTSOURCIA","AKDITAL_HOLDING","GRANDSTREAM_NETWORKS","LE_MONTASSIER_GROUP","ADECCO_MAROC","MAROC_FORCE_EMPLOI","XPERTIZE","DIGITALMA","FONDATION_ARRAWAJ","REKRUTACADEMY","SITEL","XPERTIZE_AFRICA","TRANSMEL_GROUP","INTELCOM,DEKRA_SERVICES","MARITA_IMMOBILIÈRE","MARKETING_CALL_CENTER","MAROC_INGENOV","DIGITAL_VIRGO_MAROC","RED_TIC","BRAIN_MANAGEMENT","PERCALL_DEVELOPPEMENT","JOB_DEVELOPPEMENT","VHP_ASSIST","ALUMINIUM_DU_MAROC","TECTRA","ECS_INFORMATIQUE","VISION_BUSINESS_CONSULTING","EXMC","CRYSTAL_PLACEMENT_AFRICA","MTS_SYSTEM","SOPHATEL","TEAMWILL_CONSULTING","IMEDIA24GMBH_ACANDO","CNEXIA","AXELINK_MAROC","PwC_AU_MAROC","PAUL_&_JOSÉ","DIGITALPRO_CALL","ASSURANCES_DE_LADOUR","SERTI_INFORMATIQUE","PLURIEL_RH","BIOUI_TRAVAUX","ECONOCOM_MAROC","TECTRA_CASA_TERTIAIRE_RECRUTEMENT","PROFESSIONAL_LABO","SEPALUMIC","EMPLOI.MA","ADECCO","BRICOMA"}));
		comboBox.setBounds(200, 115, 163, 22);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setForeground(new Color(81, 94, 54));
		comboBox_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String [] {"Tétouan","Settat","Tanger","International","Agadir","Béni_Mellal_Khénifra","Casablanca_Mohammedia","Dakhla","Errachidia","Fès","Guelmim","Laâyoune","Marrakech_Safi","Meknès","Oujda","Rabat_Salé_Kénitra"}));
		comboBox_1.setBounds(200, 148, 163, 22);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("");
		comboBox_2.setForeground(new Color(81, 94, 54));
		comboBox_2.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox_2.setModel(new DefaultComboBoxModel(new String [] {"allemand›courant_anglais›bon_niveau","allemand›courant_anglais›courant_français›courant","anglais›bon_niveau","anglais›bon_niveau_arabe›courant_français›courant","anglais›bon_niveau_arabe›maternelle_français›courant","anglais›bon_niveau_français›bon_niveau","anglais›bon_niveau_français›courant","anglais›courant","anglais›courant_espagnol›bon_niveau_français›bon_niveau","anglais›courant_français›bon_niveau","anglais›courant_français›courant","anglais›intermédiaire_français›courant","arabe›courant_français›courant","arabe›maternelle_français›courant","français›bon_niveau","français›courant","français›maternelle","italien›courant","néerlandais›courant"}));
		comboBox_2.setBounds(200, 181, 163, 22);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setToolTipText("");
		comboBox_3.setForeground(new Color(81, 94, 54));
		comboBox_3.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox_3.setModel(new DefaultComboBoxModel(new String [] {"Bac","Bac+1","Bac+2","Bac+3","Bac+4","Bac+5_et_plus"}));
		comboBox_3.setBounds(200, 214, 163, 22);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setToolTipText("");
		comboBox_4.setForeground(new Color(81, 94, 54));
		comboBox_4.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox_4.setModel(new DefaultComboBoxModel(new String [] {"Débutant<2ans","jeune_diplômé","Expérience>10ans","Expérience_entre_2ans_et_5_ans","Expérience_entre_5ans_et_10ans"}));
		comboBox_4.setBounds(200, 247, 163, 22);
		panel_1.add(comboBox_4);
		
		JComboBox comboBox_4_1 = new JComboBox();
		comboBox_4_1.setToolTipText("");
		comboBox_4_1.setForeground(new Color(81, 94, 54));
		comboBox_4_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
//		comboBox_4_1.setModel(new DefaultComboBoxModel(new String [] { "Commercial_vente_Métiers_des_services_R&D_gestion_de_projets","Commercial_vente_Gestion_comptabilité_finance_Métiers_des_services","RH_formation","Production_maintenance_qualité_R&D_gestion_de_projets","R&D_gestion_de_projets","Achats_Informatique_nouvelles_technologies","Commercial_vente","Informatique_nouvelles_technologies_Métiers_des_services_R&D_gestion_de_projets","Achats_Informatique","nouvelles_technologies","Achats_Informatique_nouvelles_technologies_Métiers_des_services","Achats_Informatique_nouvelles_technologies_Transport_logistique","Achats_Secretariat_assistanat","Achats_Transport_logistique","Commercial_vente_Commercial_vente_Gestion_comptabilité_finance_Métiers_des_services","Commercial_vente_Gestion_comptabilité_finance_RH_formation","Commercial_vente_Informatique_nouvelles_technologies","Commercial_vente_Informatique_nouvelles_technologies_Marketing_communication","Commercial_vente_Informatique_nouvelles_technologies_Métiers_des_services","Commercial_vente_Informatique_nouvelles_technologies_RH_formation","Commercial_vente_Management_direction_générale","Commercial_vente_Management_direction_générale_Métiers_des_services","Commercial_vente_Marketing_communication_Métiers_des_services","Commercial_vente_Marketing_communication_RH_formation","Commercial_vente_Métiers_des_services","Commercial_vente_Métiesservices_R&D_gestion_de_projets","Gestion_comptabilité_finance","Gestion_comptabilité_finance_Informatique_nouvelles_technologies","Gestion_comptabilité_finance_Informatique_nouvelles_technologies_R&D_gestion_de_projets","Gestion_comptabilité_finance_Informatique_nouvelles_technologies_RH_formation","Informatique_nouvelles_technologies","Informatique_nouvelles_technologies_Management_direction_générale","Informatique_nouvelles_technologies_Management_direction_générale_Marketing_communication","Informatique_nouvelles_technologies_Management_direction_générale_R&D_gestion_de_projets","Informatique_nouvelles_technologies_Marketing_communication","Informatique_nouvelles_technologies_Marketing_communication_Métiers_des_services","Informatique_nouvelles_technologies_Marketing_communication_R&D_gestion_de_projets","Informatique_nouvelles_technologies_Métiers_des_services","Informatique_nouvelles_technologies_Métiers_des_services_Production_maintenance_qualité","Informatique_technologies_Métiers_des_services_R&D_gestion_de_projets","Informatique_nouvelles_technologies_Métiers_du_BTP","Informatique_nouvelles_technologies_Métiers_du_BTP_Production_maintenance_qualité","Informatique_nouvelles_technologies_Métiers_du_BTP_R&D_gestion_de_projets","Informatique_nouvelles_technologies_Production_maintenance_qualité","Informatique_nouvelles_technologies_R&D_gestion_de_projets","Informatique_nouvelles_technologies_R&D_gestion_de_projets_RH_formation","Informatique_nouvelles_technologies_RH_formation","Informatique_nouvelles_technologies_Transport_logistique","Juridique","Management_direction_générale_Production_maintenance_qualité","Marketing_communication","Marketing_communication_Métiers_des_services_RH_formation","Marketing_communication_Tourisme_hôtellerie_restauration","Marketing_communication_Tourisme_hôtellerie_restauration_Transport_logistique","Métiers_des_services","Production_maintenance_qualité_R&D_gestion_de_projets_R&D_gestion_de_projets","formation","Secretariat_assistanat","Secretariat_assistanat_Tourisme_hôtellerie_restauration","Transport_logistique"}));
		comboBox_4_1.setModel(new DefaultComboBoxModel(new String [] {"CDD","CDD_Freelance","CDI","CDI_CDD","CDI_CDD_Freelance","CDI_CDD_Freelance_Alternance","CDI_Freelance","CDI_Stage","Freelance","Interim","Stage","Statutaire"}));
		comboBox_4_1.setBounds(200, 280, 163, 22);
		panel_1.add(comboBox_4_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("society : ");
		lblNewLabel_2_1_1_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1.setBounds(25, 117, 89, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Region");
		lblNewLabel_2_1_1_1_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_1.setBounds(24, 150, 89, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("Language");
		lblNewLabel_2_1_1_1_1_2.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1_2.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_2.setBounds(25, 183, 89, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1_3 = new JLabel("Level of study : ");
		lblNewLabel_2_1_1_1_1_3.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1_3.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_3.setBounds(24, 216, 178, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1_3);
		
		JLabel lblNewLabel_2_1_1_1_1_4 = new JLabel("Level of experience : ");
		lblNewLabel_2_1_1_1_1_4.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1_4.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_4.setBounds(24, 249, 166, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1_4);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1 = new JLabel("TYPE OF CONTARCT");
		lblNewLabel_2_1_1_1_1_4_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1_4_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_4_1.setBounds(24, 284, 166, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1_4_1);
		
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Warning: the options are listed in order of priority: ");
		lblNewLabel_2_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1_1_1.setFont(new Font("Stencil", Font.PLAIN, 10));
		lblNewLabel_2_1_1_1.setBounds(24, 90, 345, 14);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_4_1_1 = new JLabel("Your Job:");
		lblNewLabel_2_1_1_1_1_4_1_1.setForeground(new Color(81, 94, 54));
		lblNewLabel_2_1_1_1_1_4_1_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_4_1_1.setBounds(44, 457, 212, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1_4_1_1);
		
		JButton btnNewButton = new JButton("PREDICT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setBorder(new LineBorder(new Color(46, 123, 166), 5, true));
		btnNewButton.setBackground(new Color(143,190,217));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
		    {
				double a = comboBox.getSelectedIndex(); //societe
				double b = comboBox_4_1.getSelectedIndex(); // contrat
				double c = comboBox_1.getSelectedIndex(); // region
				double d = comboBox_4.getSelectedIndex(); // experience
				double e1 = comboBox_3.getSelectedIndex(); //etude
				double f = comboBox_2.getSelectedIndex(); //langue
                
				System.out.println(b);
				
				try
				{
            	    String contrat= cs.predict(a, b, c, d, e1, f);
					lblNewLabel.setText(contrat);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(117, 346, 156, 35);
		panel_1.add(btnNewButton);
		
		JButton btnChoix = new JButton("Choix");
		btnChoix.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnChoix.setBorder(new LineBorder(new Color(46, 123, 166), 5, true));
		btnChoix.setBackground(new Color(143, 190, 217));
		btnChoix.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) 
		    {
			choix inser= new choix();  
    		frame.setVisible(false);
    		inser.main(new String[]{});	
			}
		});
		btnChoix.setBounds(670, 27, 156, 35);
		panel_1.add(btnChoix);
		
//		Predict 
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Predict window = new Predict();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

