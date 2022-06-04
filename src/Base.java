
import java.sql.*;
import java.util.*;
import com.mysql.cj.jdbc.Driver;

public class Base 
{
	Scanner sc = new Scanner(System.in);
	private String url = "jdbc:mysql://localhost:3306/projet_java"  ;
	private String user = "root";
	private String passwd = "";
	private Connection cnx = null;
	
    public Base() 
    {
		this.url = "jdbc:mysql://localhost:3306/ecole"  ;
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
        System.out.println("Connexion bien fait");
		}
		catch (Exception e) 
		{
			System.out.println("Data base non connecte");
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
	
	public int insert_arg(String nom , String prenom , String domain , String email , String sex , String type)
	{
		String req = "INSERT INTO etudiant (nom , prenom , email , domaine ,type , sexe , password)  VALUES  ('" +nom+"','" +prenom+"','" +domain+ "','" +email+"','" +sex+"','" +type+"')";
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
//	public void update (Etudiant e) 
//	{
//		String req1 = "SELECT * FROM etudiant WHERE id = '" +e.get_Id()+"'";
//		try 
//		{
//			Statement stm1 = this.cnx.createStatement();
//			ResultSet result1 = stm1.executeQuery(req1);
//			if(result1.next())
//		     { 
//			 String req= " UPDATE etudiant SET id = '" +e.get_Id()+ "' , nom = '" +e.get_Nom()+ "', prenom ='" +e.get_Prenom()+"' , annee ='" +e.get_Anne()+ "',filiere = '"+e.get_Filiere()+"' WHERE id = "+e.get_Id()+"";
//	 	     Statement stm = cnx.createStatement();
//   		     int result = stm.executeUpdate(req);
//			  System.out.println("Etudiant possedant l'id : " +e.get_Id()+ " est bien modifie \n ");
//              } 
//        	else 
//              {
//             	System.out.println("Desole mais cet etudiant ne se trouve pas dans notre base ");
//	          }
//		}
//		catch (SQLException e1)
//		{
//			e1.printStackTrace();
//			System.out.println("Error update");
//		}
//	}
	
//	public void modifier (Etudiant e)
//	{
//		System.out.println("Veuliiez specifier quelle numero de l'etudiant a update : ");
//		int Id = sc.nextInt();
//		String req= " UPDATE etudiant SET id ="+e.get_Id()+", nom ='"+e.get_Nom()+"',prenom ='" + e.get_Prenom() +"',annee ='" +e.get_Anne()+"',filiere = '"+e.get_Filiere()+"'WHERE id = '"+Id+"'";
//		String req1 = "SELECT * FROM etudiant";
//		try 
//		{
//			Statement stm1 = this.cnx.createStatement();
//			ResultSet result1 = stm1.executeQuery(req1);
//			while(result1.next())
//				{
//					if(Id == result1.getInt("id"))
//				     { 
//				 	     Statement stm = this.cnx.createStatement();
//					     int result = stm.executeUpdate(req);
//					     System.out.println("Etudiant possedant l'id : " +Id+ "est bien modifie avec les informations de l'etudiant " + e +"\n ");
//				     }
//					else
//					{
//						System.out.println("Cet id n'existe pas dans la base donne");
//					}
//				}
//			} 
//		catch (SQLException e1)
//		{
//			System.out.println("Error update");
//		}
//	}
	
	public void modifier_arg( String a , String b ,int idd, String aa , String bb , String cc , String dd)
	{
		String req= " UPDATE etudiant SET id ="+idd+", nom ='"+aa+"',prenom ='"+bb+"',filiere ='"+cc+"', annee ='"+dd+"' WHERE  (nom = '"+a+"' AND prenom = '" +b+"')";
		try 
		{
         Statement stm = this.cnx.createStatement();
         int result = stm.executeUpdate(req);
         System.out.println(" Etudiant est bien modifie ");
        }
		catch (SQLException e1)
		{
			System.out.println("Error update");
		}
	}
	
	
	public void delete(Connection cnx)
	{
		String req = "";
		try
		{
		Statement stm = cnx.createStatement();
		int result = stm.executeUpdate(req);
		}
		catch (Exception e)
		{
			System.out.println("Error delete");
		}
	}

}
