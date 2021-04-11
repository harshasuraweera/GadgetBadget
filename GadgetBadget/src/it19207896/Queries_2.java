package it19207896;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries_2 {
	
	
	
	//Add product 
	public static void addProduct(Connection connection,String projectId,String title,String sDesc,String lDesc,String price,String downloadLink,String feturedImage) {
		
		String sql = "INSERT INTO products (productId,title, sDesc, lDesc,price,downloadLink,feturedImage) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//pre.setString(1,storeId);
			pre.setString(1, projectId);
			pre.setString(2, title);
			pre.setString(3, sDesc);
			pre.setString(4, lDesc);
			pre.setString(5, price);
			pre.setString(6,downloadLink);
			pre.setNString(7, feturedImage);

			
			pre.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	
	//Load Details to display details table
	public static String laodDetails(Connection conn,String id) throws SQLException {
		
		String output = "";
		
		String sql = "SELECT * FROM cart p WHERE p.id = '"+id+"' ";
		
		try (PreparedStatement pre = conn.prepareStatement(sql);
		         ResultSet rs = pre.executeQuery()) {

		        while (rs.next()) {
		        	
		        	//String id = rs.getString("id");
		        	String title = rs.getString("title");
		        	String lDesc = rs.getString("lDesc");
		        	String price = rs.getString("price");
		        	String downloadLink = rs.getString("downloadLink");
		        	String feturedImage = rs.getString("feturedImage");
		
		
		
		        }

		}
		return output;
		
	}
    

}
