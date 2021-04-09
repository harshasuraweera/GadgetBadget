package it19180380;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProjectDbUtil {
	
	//Submit new project :
	
	public static boolean submitProjects(String title, String ShortDes , String LongDes , String srcLink , String videoLink )
	{
		boolean isSuccess = false;
		
		//Create Database Connection :
		
		 String url = "jdbc:mysql://localhost:3306/projectservice";
		 String userName = "root";
	     String password = "hashini";	
	     
	     try {
	    	 
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection(url, userName, password);
	    	    Statement stmt = con.createStatement();
	    	    String sql = "insert into projects values (0,'"+title+"' , '"+ShortDes+"' , '"+LongDes+"' , '"+srcLink+"' , '"+videoLink+"' )";
	    	    int rs = stmt.executeUpdate(sql);
	    	    
	    	    if(rs > 0)
	    	    {
	    	    	isSuccess = true;
	    
	    	    }else {
	    	    	
	    	    	isSuccess = false;
	    	    }
	    	    
	    	    
	     }catch (Exception e){
	    	     e.printStackTrace();
	     }
	
		return isSuccess;
		
	}

}
