package it19180380;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ProjectServiceDBConnection;

public class EditProjectDetails {
	
	public Projects get_values_of_projects(String Project_Id){
		ProjectServiceDBConnection conn=new ProjectServiceDBConnection();
		Connection connection=conn.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		 Projects projects=new Projects();
		
		try {
		String querry="select * from projects where Project_Id=?";
		ps=connection.prepareStatement(querry);	
		ps.setString(1, Project_Id);
		rs=ps.executeQuery();
		while(rs.next()){
		 
		
		  projects.setProject_Id(rs.getString("Project_Id"));
		  projects.setProject_Title(rs.getString("Project_Title"));
		  projects.setProject_ShortDes(rs.getString("Project_ShortDes"));
		  projects.setProject_LongDes(rs.getString("Project_LongDes"));
		  projects.setProject_Srclink(rs.getString("Project_Srclink"));
		  projects.setProject_Videolink(rs.getString("Project_Videolink"));
		
		}
		} catch (Exception e) {
		System.out.println(e);
		}
		return projects;
		}

}
