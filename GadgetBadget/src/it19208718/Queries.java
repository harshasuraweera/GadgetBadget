package it19208718;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
	
	
	public static String fetchProducts(Connection conn) throws SQLException {
		
		
		
		String output = "";
		String sql = "SELECT * FROM testproducts";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	output += "<div class=\"col-sm-6 col-md-4 product-item animation-element slide-top-left\">\r\n" + 
		        			"                    <div class=\"product-container\">\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-md-12\"><a class=\"product-image\" href=\"single-product.html\"><img src=\"assets/assets_har/img/iphone6.jpg\"></a></div>\r\n" + 
		        			"                        </div>\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-8 col-lg-12\">\r\n" + 
		        			"                                <h5> "+rs.getString("name")+" <br></h5>\r\n" + 
		        			"                            </div>\r\n" + 
		        			"                        </div>\r\n" + 
		        			"                        <div class=\"product-rating\"><a class=\"small-text\" href=\"#\" style=\"margin-left: 10px;\"><strong> "+rs.getString("sales") + "Sales"+" </strong></a></div>\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-12\">\r\n" + 
		        			"                                <p class=\"product-description\"> "+rs.getString("sDesc")+" </p>\r\n" + 
		        			"                                <div class=\"row\" style=\"padding-left: 0px;\">\r\n" + 
		        			"                                    <div class=\"col-6\"><button class=\"btn btn-light\" type=\"button\" style=\"background: var(--indigo);margin-left: 0px;\">Add to Cart</button></div>\r\n" + 
		        			"                                    <div class=\"col-6\">\r\n" + 
		        			"                                        <p class=\"product-price\"> "+"$"+rs.getString("price")+".00"+" </p>\r\n" + 
		        			"                                    </div>\r\n" + 
		        			"                                </div>\r\n" + 
		        			"                            </div>\r\n" + 
		        			"                        </div>\r\n" + 
		        			"                    </div>\r\n" + 
		        			"                </div>";
		        	
		        	
		        }
		 }
		
		return output;
		
	}
	
	

	
	
	
	

}
