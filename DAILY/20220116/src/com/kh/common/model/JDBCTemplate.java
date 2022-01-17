package com.kh.common.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

	public static Connection getConnection() {
		Properties prop = new Properties();
		
		Connection conn = null;
		
		String fileName = JDBCTemplate.class.getResource("/sql/driver/driver/properties").getPath();
		
		try {
			prop.load(new FileInputStream(fileName));
			
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),
												prop.getProperty("username"),
												prop.getProperty("password"));
												
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void close(Connection conn) {
		
	}
}
