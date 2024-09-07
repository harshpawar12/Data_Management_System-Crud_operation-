package com.project.deo;

import java.sql.Connection;
import java.sql.DriverManager;

public class connet {
	
	
	public static Connection suceess()
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","12345");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	


}
