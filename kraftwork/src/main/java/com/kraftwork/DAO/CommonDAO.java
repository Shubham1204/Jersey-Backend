package com.kraftwork.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDAO {
	public static Connection getConnection() throws ClassNotFoundException  {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kraft","root","newgen123");
		} catch (SQLException e) {
			return null;
		}
		if(con!=null) {
			System.out.println("Connnection Created.");
			return con;
		}
		else {
			System.out.println("Connection Not Created.");
			return null;
		}
	}
}
