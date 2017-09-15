package com.hw_sw.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection conn=null;
	
	private DBUtil() {
		
	}
	
	public static Connection getConnect(){
		
		if(conn == null)
		{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String cs="jdbc:mysql://localhost:3309/techSupport";
		
		try {
			conn=DriverManager.getConnection(cs,"root","mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		
		
		return conn;
		
	}
	
	public static void closeConnection(){
		
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
}
