package Informations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class based 
{
	Scanner sc = new Scanner(System.in);
	private String url = "jdbc:mysql://localhost:3306/project"  ;
	private String user = "root";
	private String passwd = "";
	private Connection cnx = null;
	
    public based() 
    {
		this.url = "jdbc:mysql://localhost:3306/project"  ;
		this.user = "root";
		this.passwd = "";
		this.cnx = null;
	}
	//	methodes
	public void connexion() 
	{
		try
		{
		Class c =Class.forName("com.mysql.cj.jdbc.Driver");
        Driver pilote = (Driver)c.getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(pilote);
        this.cnx = DriverManager.getConnection(this.url,this.user,this.passwd);
//        System.out.println("Connexion bien fait");
		}
		catch (Exception e) 
		{
			System.out.println("Data base non connecte");
		}
	}
	
	public int insert_arg(String nom , String prenom ,String email , String domain , String type, String sex , String password )
	{
		String req = "INSERT INTO etudiant (nom , prenom , email , domaine ,type , sexe , password)  VALUES  ('" +nom+"','" +prenom+"','" +email+"','" +domain+ "','" +type+"','" +sex+"','"+password+"')";
		try
		{
		Statement stm = this.cnx.createStatement();
		int result = stm.executeUpdate(req);
		System.out.println("Insert bien fait");
		return result;
		}
		catch (Exception e1)
		{
			System.out.println("Error insert");
			return 0;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ResultSet select_arg(String nomm , String prenomm) 
	{
		String req = "SELECT * FROM etudiant WHERE nom = '"+nomm+"' , prenom = '"+prenomm+"' ";
		Statement stm=null;
		ResultSet result =null;
		try
		{
		stm = this.cnx.createStatement();
		result = stm.executeQuery(req);
			if(result.next())
			{
				int id = result.getInt("id");
				String nom = result.getString("nom");
        		String prenom = result.getString("prenom");
        		String annee = result.getString("annee");
        		String filiere = result.getString("filiere");
			}
			return result;
		}
		catch (Exception e)
		{
			System.out.println("Error select");
			return result;
		}	
	}
	public ResultSet select() 
	{
		String req = "SELECT * FROM etudiant";
		Statement stm=null;
		ResultSet result =null;
		try
		{
		stm = this.cnx.createStatement();
		result = stm.executeQuery(req);
		System.out.println("affichage des donnees \n");
		
			int i=1;
			while(result.next())
			{
				System.out.println("L'etudiant numero : "+i);
				int id = result.getInt("id");
				String nom = result.getString("nom");
        		String prenom = result.getString("prenom");
        		String annee = result.getString("annee");
        		String filiere = result.getString("filiere");
        		System.out.println("\n L'identifiant de l'etudiant est : "+id +"\n Son nom est : "+nom + "\n son prenom est : " + prenom +"\n l'annee scolaire est :"+annee+" \n Sa filiere est : "+filiere );
        		System.out.println("****************");
        		i+=1;
			}
			return result;
		}
		catch (Exception e)
		{
			System.out.println("Error select");
			return result;
		}	
	}
}
