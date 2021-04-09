package com;

import java.sql.Connection;
import java.sql.DriverManager;


public class ProductServiceDBConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/productservise";
	private static String userName = "root";
    private static String password = "Highschool23*";	
	private static Connection conn;


	public static Connection getConnection() {
	      
	    try {
	        
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(url,userName, password);
	      System.out.println("Database connection is success!!!");
	      
	    
	        
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	        System.out.println("Database connection is not success!!!");
	    }
	      
	      
	      
	    return conn;
	  }

}
