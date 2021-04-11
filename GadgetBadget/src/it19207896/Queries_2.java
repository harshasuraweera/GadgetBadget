package it19207896;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries_2 {
	
	
	
	//Add product 
	public static void addProduct(Connection connection,String title,String sDesc,String lDesc,String price,String downloadLink,String feturedImage) {
		
		String sql = "INSERT INTO products (title, sDesc, lDesc,price,downloadLink,feturedImage) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//pre.setString(1,storeId);
			//pre.setString(2, productId);
			pre.setString(1, title);
			pre.setString(2, sDesc);
			pre.setString(3, lDesc);
			pre.setString(4, price);
			pre.setString(5,downloadLink);
			pre.setNString(6, feturedImage);

			
			pre.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
