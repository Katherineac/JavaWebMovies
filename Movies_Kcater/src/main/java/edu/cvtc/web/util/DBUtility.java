package edu.cvtc.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Katherine Cater
 *
 */
public class DBUtility {
	
	private static final String CONNECTION = "jdbc:sqlite:movie.db";
	public static final int TIMEOUT = 30;
	public static final String DRIVER_NAME = "org.sqlite.JDBC";
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		//register the driver
		Class.forName(DRIVER_NAME);
		
		//create the database collection
		return DriverManager.getConnection(CONNECTION);
		
	}
	
	public static void closeConnection(final Connection connection, final Statement statement){
		try {
			if (null != connection){
				connection.close();
			}
			if (null != statement){				
				statement.close();
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		
	}

}
