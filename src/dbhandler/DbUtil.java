package dbhandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DbUtil {
	protected Connection conn;
	protected ResultSet results;
	protected PreparedStatement ps = null;
	
	public DbUtil() throws IllegalAccessException, ClassNotFoundException, InstantiationException{
	//Define connection CONN_STRING , USERNAME, PASSWORD
		final String driver = "com.mysql.jdbc.Driver";
		final String USERNAME = "root";
		final String PASSWORD = "";
		final String CONN_STRING = "jdbc:mysql://localhost:3306/cis5800project";
		
		//create connection on instantiation. 
		
		try {
			Class.forName(driver).newInstance();
			this.conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("it not working");
	
		}
	}
	
	
//Method closes connection
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// getter and setters for connection and result sets.

	
}

