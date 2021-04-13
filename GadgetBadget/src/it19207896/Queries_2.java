package it19207896;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ProductServiceDBConnection;

public class Queries_2 {
	
	
	
	//Add product 
	public static void addProduct(Connection connection,String productId,String title,String sDesc,String lDesc,String price,String downloadLink,String feturedImage) {
		
		String sql = "INSERT INTO products (productId,title, sDesc, lDesc,price,downloadLink,feturedImage) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//pre.setString(1,storeId);
			pre.setString(1, productId);
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

	
	
	//Remove Details from display details table
	public static  void deleteProducts(Connection connection,String productId) {
		
		
		
		String sql = "DELETE FROM products WHERE productId = '"+productId+"'";
		try {

			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		
	}
	
	
	//select details by product ID
	public Products selectProduct(String productId) {
		String querry = "SELECT * from products where productId=?";
		Connection connection = ProductServiceDBConnection.getConnection();
		
		Products products = new Products();
		
		try {
			PreparedStatement ps = connection.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				products.setProductId(rs.getString("productId"));
				products.setTitle(rs.getString("title"));
				products.setsDesc(rs.getString("sDesc"));
				products.setlDesc(rs.getString("lDesc"));
				products.setPrice(rs.getString("price"));
				products.setDownloadLink(rs.getString("downloadLink"));
				products.setFeturedImage(rs.getString("feturedImage"));
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return products;
		
		
		
		
	}
		
	//Update products
	public static void updateProducts(Connection connection,String productId,String title,String sDesc,String lDesc,String price,String downloadLink,String feturedImage) {
		
		String sql = "UPDATE products set productId=?,title=?,sDesc=?,lDesc=?,price=?,downloadLink=?,feturedImage=?  where  productId=?";
		
		try {
			PreparedStatement pre = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//pre.setString(1,storeId);
			pre.setString(1, productId);
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
			System.out.println(e);
		}
		
		
		
	
		
		
	}
	

}
