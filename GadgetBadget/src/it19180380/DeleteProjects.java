package it19180380;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ProjectServiceDBConnection;

public class DeleteProjects {
	
	public void delete_projects(String Project_Id){
		ProjectServiceDBConnection conn=new ProjectServiceDBConnection();
		Connection connection=conn.getConnection();
		PreparedStatement ps=null;

	
		try {
		String querry="delete from projects where Project_Id=?";
		ps=connection.prepareStatement(querry);	
		ps.setString(1, Project_Id);
		ps.executeUpdate();
		
		} catch (Exception e) {
		System.out.println(e);
		}
	
		}

}
