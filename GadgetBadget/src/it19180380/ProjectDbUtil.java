package it19180380;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ProjectServiceDBConnection;

public class ProjectDbUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	
	
	//Submit new project :
	
	public static boolean submitProjects(String title, String ShortDes , String LongDes , String srcLink , String videoLink )
	{
		boolean isSuccess = false;
		 
	     try {
	    	 	con = ProjectServiceDBConnection.getConnection();
	    	 	stmt = con.createStatement();
	    	 	
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
	
	//View All Details 
	
	public static boolean ViewAllProjects()
	{
		boolean isSuccess = false;
		 
	     try {
	    	 	con = ProjectServiceDBConnection.getConnection();
	    	 	stmt = con.createStatement();
	    	 	
	    	    String sql = "select * from projects ";
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
    
    
    
    
    
    
    

