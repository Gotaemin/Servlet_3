package com.google.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnection() throws Exception{
		
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
				
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
}
