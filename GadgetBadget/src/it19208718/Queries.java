package it19208718;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {
	
	
	
	public static String fetchAllProducts(Connection conn) throws SQLException {
		
		String output = "";
		String sql = "SELECT * FROM testproducts";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	String productName = rs.getString("name");
		        	String shortDescription = rs.getString("sDesc");
		        	String totalSales = rs.getString("sales");
		        	String productPrice = rs.getString("price");
		        	
		        	output += "<div class=\"col-sm-6 col-md-4 product-item animation-element slide-top-left\">\r\n" + 
		        			"                    <div class=\"product-container\">\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-md-12\"><a class=\"product-image\" href=\"single-product.html\"><img src=\"assets/assets_har/img/iphone6.jpg\"></a></div>\r\n" + 
		        			"                        </div>\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-8 col-lg-12\">\r\n" + 
		        			"                                <h5> "+productName+" <br></h5>\r\n" + 
		        			"                            </div>\r\n" + 
		        			"                        </div>\r\n" + 
		        			"                        <div class=\"product-rating\"><a class=\"small-text\" href=\"#\" style=\"margin-left: 10px;\"><strong> "+ totalSales + "Sales"+" </strong></a></div>\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-12\">\r\n" + 
		        			"                                <p class=\"product-description\"> "+shortDescription+" </p>\r\n" + 
		        			"                                <div class=\"row\" style=\"padding-left: 0px;\">\r\n" + 
		        			"                                   <div class=\"col-6\">"+
		        			
		        			"										<form method='post' action='AddToCartServlet' >"+
		        														"<input type= 'hidden' name='productName' value= "+productName+" >"+
		        														"<input type='submit' class='btn btn-light' style=\"background: var(--indigo);margin-left: 0px; color:white;\" value= 'Add to cart'>"+
		        														
		        													"</form>"+
		        			
		        			"									</div>\r\n"+ 
		        			
		        			
		        			
		        			"                                    <div class=\"col-6\">\r\n" + 
		        			"                                        <p class=\"product-price\"> "+"$"+ productPrice +".00"+" </p>\r\n" + 
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
	
	
	
	public static String fetchTopSellingProducts(Connection conn) throws SQLException {
		
		String output = "";
		String sql = "SELECT * FROM testproducts WHERE sales > 20";
		
		try (
				PreparedStatement stmt = conn.prepareStatement(sql);
		        ResultSet rs = stmt.executeQuery()) {
			
				int productCount = 0;

		        while (rs.next()) {
		        	
		        	if(productCount==6) {
		        		break;
		        	}
		        	
		        	String productId = rs.getString("id");
		        	String productName = rs.getString("name");
		        	String shortDescription = rs.getString("sDesc");
		        	String totalSales = rs.getString("sales");
		        	String productPrice = rs.getString("price");
		        	
		        	String loggedUsername = "user001";
		        	String defaultQuantity = "1";
		        	
		        	output += "<div class=\"col-sm-6 col-md-4 product-item animation-element slide-top-left\">\r\n" + 
		        			"                    <div class=\"product-container\">\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-md-12\"><a class=\"product-image\" href=\"single-product.html\"><img src=\"assets/assets_har/img/iphone6.jpg\"></a></div>\r\n" + 
		        			"                        </div>\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-8 col-lg-12\">\r\n" + 
		        			"                                <h5> "+productName+" <br></h5>\r\n" + 
		        			"                            </div>\r\n" + 
		        			"                        </div>\r\n" + 
		        			"                        <div class=\"product-rating\"><a class=\"small-text\" href=\"#\" style=\"margin-left: 10px;\"><strong> "+ totalSales + "Sales"+" </strong></a></div>\r\n" + 
		        			"                        <div class=\"row\">\r\n" + 
		        			"                            <div class=\"col-12\">\r\n" + 
		        			"                                <p class=\"product-description\"> "+shortDescription+" </p>\r\n" + 
		        			"                                <div class=\"row\" style=\"padding-left: 0px;\">\r\n" + 
		        			"                                   <div class=\"col-6\">"+
		        			
		        			"										<form method='post' action='AddToCartServlet' >"+
		        														"<input type= 'hidden' name='loggedUsername' value= "+loggedUsername+" >"+
		        														"<input type= 'hidden' name='loggedUsername' value= "+productId+" >"+
		        														"<input type= 'hidden' name='productName' value= "+productName+" >"+
		        														"<input type= 'hidden' name='shortDescription' value= "+shortDescription+" >"+
		        														"<input type= 'hidden' name='productPrice' value= "+productPrice+" >"+
		        														"<input type= 'hidden' name='defaultQuantity' value= "+defaultQuantity+" >"+
		        														"<input type='submit' class='btn btn-light' style=\"background: var(--indigo);margin-left: 0px; color:white;\" value= 'Add to cart'>"+
		        														
		        													"</form>"+
		        			
		        			"									</div>\r\n"+ 
		        			
		        			
		        			
		        			"                                    <div class=\"col-6\">\r\n" + 
		        			"                                        <p class=\"product-price\"> "+"$"+ productPrice +".00"+" </p>\r\n" + 
		        			"                                    </div>\r\n" + 
		        			"                                </div>\r\n" + 
		        			"                            </div>\r\n" + 
		        			"                        </div>\r\n" + 
		        			"                    </div>\r\n" + 
		        			"                </div>";
		        	
		        	productCount++;
		        }
		 }
		
		return output;
		
	}
	
	
	
	public static void addToCart(Connection conn, String username , String productId, String productName, String shortDescription, String quantity, String price) {
		
		String sql = "INSERT INTO cart (loggedUsername, productId, productName, quantity, productPrice) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, username);
			pstmt.setString(2, productId);
			pstmt.setString(3, productName);
			pstmt.setString(4, quantity);
			pstmt.setString(5, price);
			
			pstmt.executeUpdate();
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	//load items to cart
	public static String fetchCartDetails(Connection conn, String loggedUsername) throws SQLException {
		
		String output = "";
		
		String sql = "SELECT * FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"' ";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	String productName = rs.getString("productName");
		        	String quantity = rs.getString("quantity");
		        	String productPrice = rs.getString("productPrice");
		        	
		        	String cartId = rs.getString("cartId");
		        	
		        	
		        	output += "<tr>\r\n" + 
		        			"                  <th scope=\"row\" class=\"border-0\">\r\n" + 
		        			"                    <div class=\"p-2\">\r\n" + 
		        			"                      <img src=\"https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-1_zrifhn.jpg\" alt=\"\" width=\"70\" class=\"img-fluid rounded shadow-sm\">\r\n" + 
		        			"                      <div class=\"ml-3 d-inline-block align-middle\">\r\n" + 
		        			"                        <h5 class=\"mb-0\"> <a href=\"#\" class=\"text-dark d-inline-block align-middle\"> "+productName+" </a></h5>\r\n" + 
		        			"                      </div>\r\n" + 
		        			"                    </div>\r\n" + 
		        			"                  </th>\r\n" + 
		        			"                  <td class=\"border-0 align-middle\"><strong> $"+productPrice+".00 </strong></td>\r\n" + 
		        			"                  <td class=\"border-0 align-middle\">"+
		        			
		        			"				<form>"+
		        			"					<input type='number' disabled value ="+quantity+" style=\"width:50px;font-weight: bold; \"></td>\r\n" +
		        								
		        			"				</form>"+
		        			"                  <td class=\"border-0 align-middle\">"+
		        			
		        			
		        			"				<form method='post' action='DeleteFromCart'>"+
		        			"					<input type='hidden' name = 'cartId' value = "+cartId+"> "+
		        			"					<button type='submit' name = 'cartId' style=\"background-color: Transparent; background-repeat:no-repeat; border: none; cursor:pointer; overflow: hidden; outline:none;\"> <i class=\"fa fa-trash\"></i></button>"+	
		        			"				</form>"+
		        			
		        			"				</td>\r\n" + 
		        			
		        			
		        			"                </tr>";
		        	
		        }
		 }
		
		return output;
	}
	
	
	//get products in the cart as a list
	public static String getProductNameAsList(Connection conn, String loggedUsername) throws SQLException {
		
		String productNameList = "";
		
		String sql = "SELECT * FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"' ";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	productNameList += rs.getString("productName") + " , ";


		        }
		 }
		return productNameList;
	}
	
	
	
	//remove item from cart
	public static void deleteFromCart(Connection conn, String cartId) {
		
		String sql = "DELETE FROM cart WHERE cartId = '"+Integer.parseInt(cartId)+"' ";
		try {

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	//calculate total price on cart
	public static int calculateCartTotal(Connection conn, String loggedUsername) throws SQLException {
		
		int total = 0;
		
		String sql = "SELECT SUM(productPrice) FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"'  ";

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next(); // SELECT count(*) always returns exactly 1 row
		total = rs.getInt(1); // Get value of first column
         
       
		return total;
	}
	
	
	
	
	
	public static void payments(Connection conn, String satusCode) {
		
		String sql = "INSERT INTO payments (statusCode) VALUES (?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, satusCode);
			
			
			pstmt.executeUpdate();
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	

}
