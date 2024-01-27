package com.plant.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection establishConnection() {
		
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PlantProject?user=root&password=Priya2003_25");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		
		Connection con=establishConnection();
		if(con!=null) 
			System.out.println("Connection is made successfully!!");
		
		else
			System.out.println("Error in connection");
	}
	
}
