package it19208718;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PaymentServiceDBConnection {


	static Connection conn = null;
	@SuppressWarnings("rawtypes")
	Statement stmt = null;
	static String url = "jdbc:mysql://localhost:3030/paymentservice";
	static String userName = "root";
	static String password = "1234";
	  


	public static Connection getConnection() {
	      
	    try {
	        
	      Class.forName("com.mysql.cj.jdbc.Driver"); 
	      conn = DriverManager.getConnection(url,userName, password);
	      
	    //  System.out.println("Database connection is success!!!");
	        
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	        System.out.println("Database connection is not success!!!");
	    }
	      
	      
	      
	    return conn;
	  }
	
	
}
