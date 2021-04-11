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
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	
	
	//Submit new project :
	
	public static boolean submitProjects(String title,String RandomprojectID, String ShortDes , String LongDes ,String image, String srcLink , String videoLink )
	{
		boolean isSuccess = false;
		 
	     try {
	    	 	con = ProjectServiceDBConnection.getConnection();
	    	 	stmt = con.createStatement();
	    	 	
	    	    String sql = "insert into projects (randomProj_ID, Project_Title, Project_ShortDes, Project_LongDes,Project_Image, Project_Srclink, Project_Videolink) values ('"+RandomprojectID+"', '"+title+"' , '"+ShortDes+"' , '"+LongDes+"' ,'"+image+"', '"+srcLink+"' , '"+videoLink+"' )";
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
	
	//Update Project Details
	
	public static boolean updateProjects(String Project_Id,String Project_Title,String Project_ShortDes , String Project_LongDes, String Project_Srclink , String Project_Videolink)
	{
		
		try {
			
    	 	con = ProjectServiceDBConnection.getConnection();
    	 	stmt = con.createStatement();
    	 	
    	 	String sql ="update projects set Project_Title='"+Project_Title+"' , Project_ShortDes='"+Project_ShortDes+"' , Project_LongDes='"+Project_LongDes+"' , Project_Srclink='"+Project_Srclink+"' , Project_Videolink='"+Project_Videolink+"'"+"where Project_Id='"+Project_Id+"'";
			int rs = stmt.executeUpdate(sql);
    	 	
			if(rs > 0)
			{
				isSuccess =  true;
			}else {
				
				isSuccess =  false;
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return isSuccess;
	}
    
    
 }
    
    
    
    
    
    
    

