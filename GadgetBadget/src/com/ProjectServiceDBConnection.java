package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProjectServiceDBConnection {

	private static String url = "jdbc:mysql://localhost:3306/projectservice";
	private static String userName = "root";
    private static String password = "hashini";	
	private static Connection con;
    
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("DataBase Connection is success!!");
			
		}
		catch(Exception e)
		{
			System.out.println("DataBase Connection is not success!!");
		}
		
		return con;
	}
}