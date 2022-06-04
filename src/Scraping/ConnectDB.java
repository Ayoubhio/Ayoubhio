package Scraping;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectDB {
	
	private Connection connection;
	
	public ConnectDB(){
		
		try {
			// load and instantiate the driver
			Class c =Class.forName("com.mysql.cj.jdbc.Driver");
	        Driver pilote = (Driver)c.getDeclaredConstructor().newInstance();
	        DriverManager.registerDriver(pilote);
	        // connection to the base
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root",""); 
	        
	        System.out.println("Connection to the DB is successful");
		}catch(Exception e) {
		      e.printStackTrace();
		}
	}
	
	public void edit(String sql )throws SQLException{
		
		try 
		{
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{   	
			e.printStackTrace();
		}
	}
	
}
