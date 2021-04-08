package it19208718;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Queries {
	
	
	// Fetch all products - from product service DB - tharuni's db
	public static String fetchAllProducts(Connection conn, String loggedUsernameToAddCart, String search) throws SQLException {
		
		String sql = "";
		
		if(search.equals("all")) {
			 sql = "SELECT * FROM testproducts";
		}else if(!search.equals("all")) {
			 sql = "SELECT * FROM testproducts WHERE name LIKE '%"+search+"%' ";
		}
		
		String output = "";
		
		
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	String productId = rs.getString("productId");
		        	String productName = rs.getString("name");
		        	String shortDescription = rs.getString("sDesc");
		        	String totalSales = rs.getString("sales");
		        	String productPrice = rs.getString("price");
		        	
		        	String loggedUsername = loggedUsernameToAddCart;
		        	String defaultQuantity = "1";
		        	
		        	
		        	//Find if the user already purchased this product or not
		        	boolean thisIsAlreadyPurchased = checkAlreadyPurchasedOrNot(conn, loggedUsername, productId);
		        	
		        	String disableOrEnableAddToCart = "";
		        	String btnValue = "Add to Cart";
		        	
		        	if(thisIsAlreadyPurchased) { //purchased
		        		disableOrEnableAddToCart = "disabled";
		        		btnValue = "Owned";
		        	}
		        	
		        	
		        	
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
		        														"<input type= 'hidden' name='productId' value= "+productId+" >"+
		        														"<input type= 'hidden' name='productName' value= "+productName+" >"+
		        														"<input type= 'hidden' name='shortDescription' value= "+shortDescription+" >"+
		        														"<input type= 'hidden' name='productPrice' value= "+productPrice+" >"+
		        														"<input type= 'hidden' name='defaultQuantity' value= "+defaultQuantity+" >"+
		        														"<input type='submit' class='btn btn-light' style=\"background: var(--indigo);margin-left: 0px; color:white;\" value= '"+btnValue+"'  "+disableOrEnableAddToCart+"     >    "+                                 
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
	
	
	// Fetch high selling products - from product service DB - tharuni's db
	public static String fetchTopSellingProducts(Connection conn, String loggedUsernameToAddCart) throws SQLException {
		
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
		        	
		        	String productId = rs.getString("productId");
		        	String productName = rs.getString("name");
		        	String shortDescription = rs.getString("sDesc");
		        	String totalSales = rs.getString("sales");
		        	String productPrice = rs.getString("price");
		        	
		        	String loggedUsername = loggedUsernameToAddCart;
		        	String defaultQuantity = "1";

		        	
		        	//Find if the user already purchased this product or not
		        	boolean thisIsAlreadyPurchased = checkAlreadyPurchasedOrNot(conn, loggedUsername, productId);
		        	
		        	String disableOrEnableAddToCart = "";
		        	String btnValue = "Add to Cart";
		        	
		        	if(thisIsAlreadyPurchased) { //purchased
		        		disableOrEnableAddToCart = "disabled";
		        		btnValue = "Owned";
		        	}
		        	
		        	
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
		        														"<input type= 'hidden' name='productId' value= "+productId+" >"+
		        														"<input type= 'hidden' name='productName' value= "+productName+" >"+
		        														"<input type= 'hidden' name='shortDescription' value= "+shortDescription+" >"+
		        														"<input type= 'hidden' name='productPrice' value= "+productPrice+" >"+
		        														"<input type= 'hidden' name='defaultQuantity' value= "+defaultQuantity+" >"+
		        														"<input type='submit' class='btn btn-light' style=\"background: var(--indigo);margin-left: 0px; color:white;\" value= '"+btnValue+"'  "+disableOrEnableAddToCart+"   >"+
		        														
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
	
	
	//Find if the user already purchased this product or not
	public static boolean checkAlreadyPurchasedOrNot(Connection conn, String loggedUsername, String productId) throws SQLException {
		
		boolean thisIsAlreadyPurchased = false;
		
		String sql = "SELECT * FROM mydownloads WHERE paidUsername= '"+loggedUsername+"' and paidProductId = '"+productId+"' ";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
				
		if(rs.next()) {
			thisIsAlreadyPurchased = true; //purchased
		}else {
			thisIsAlreadyPurchased = false; // not purchased
		}
		
		return thisIsAlreadyPurchased;
		
		
	}
	
	
	
	
	//Add products to cart - Related to PaymentServiceDBConnection - my Db done
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
	
	
	//load items to cart - Fetch from PaymentServiceDBConnection - my Db done
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
	
	
	//get products in the cart as a list - FROM PaymentServiceDBConnection - my Db done
	public static String getProductNameAsListInCartForSpecificUser(Connection conn, String loggedUsername) throws SQLException {
		
		String productNameList = "";
		
		String sql = "SELECT * FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"' ";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	productNameList += rs.getString("productName") + " | ";


		        }
		 }
		return productNameList;
	}
	
	
	//get product ID list from cart to set download enable
	public static ArrayList<String> getProductIdListToArrayFromCartAfterPaymentSuccess(Connection conn, String loggedUsername) throws SQLException {
		
		ArrayList<String> productIdsInTheCart = new ArrayList<String>();
		
		String sql = "SELECT * FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"' ";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	productIdsInTheCart.add(rs.getString("productId"));

		        }
		 }
		
		return productIdsInTheCart;
	}
	
	
	//get product NAME list from cart to set download enable
	public static ArrayList<String> getProductNameListToArrayFromCartAfterPaymentSuccess(Connection conn, String loggedUsername) throws SQLException {
		
		ArrayList<String> productIdsInTheCart = new ArrayList<String>();
		
		String sql = "SELECT * FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"' ";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	productIdsInTheCart.add(rs.getString("productName"));

		        }
		 }
		
		return productIdsInTheCart;
	}
		
	
	//get product price for list of cart to insert to completed orders
	public static ArrayList<String> getProductPicesForEachCartItem(Connection conn, String loggedUsername) throws SQLException {
		
		ArrayList<String> productPrices = new ArrayList<String>();
		
		String sql = "SELECT * FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"'  ";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	productPrices.add(rs.getString("productPrice"));

		        }
		 }
		
		return productPrices;
	}
	
	
	
	//get product Download Link list from cart to set download enable
	public static String getProductDownloadLinkListToArrayFromCartAfterPaymentSuccess(Connection conn, String productId) throws SQLException {
		
		String productDownloadLinkInTheCart = "";
		
		String sql = "SELECT * FROM testProducts tp WHERE tp.productId = '"+productId+"' ";
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	productDownloadLinkInTheCart = rs.getString("downloadLink");

		        }
		 }
		
		return productDownloadLinkInTheCart;
	}
	
	
	
	
	
	
	//remove item from cart - FROM PaymentServiceDBConnection - my Db done
	public static void deleteFromCart(Connection conn, String cartId) {
		
		String sql = "DELETE FROM cart WHERE cartId = '"+Integer.parseInt(cartId)+"' ";
		try {

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	//calculate total price on cart - FROM PaymentServiceDBConnection - my Db done
	public static int calculateCartTotal(Connection conn, String loggedUsername) throws SQLException {
		
		int total = 0;
		
		String sql = "SELECT SUM(productPrice) FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"'  ";

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next(); // SELECT count(*) always returns exactly 1 row
		total = rs.getInt(1); // Get value of first column
         
       
		return total;
	}
	
	
	
	//get cart item count for specific user
	public static int getCartItemCountForSpecificUser(Connection conn, String loggedUsername) throws SQLException {
		
		int total = 0;
		
		String sql = "SELECT COUNT(cartId) FROM cart c WHERE c.loggedUsername = '"+loggedUsername+"' ";

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next(); // SELECT count(*) always returns exactly 1 row
		total = rs.getInt(1); // Get value of first column
         
       
		return total;
	}
	
	
	
	
	//make cart empty
	public static void emptyCart(Connection conn, String loggedUsername) {
		
		String sql = "DELETE FROM cart WHERE loggedUsername = '"+loggedUsername+"' ";
		try {

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//insert into completed products
	public static void insertIntoCompletedOrdersAfterPaymentSuccess(Connection conn, String orderId, String storeId, String prductId, String productName, String price ) {
		
		String sql = "INSERT INTO completedorder (orderId, storeId, productId, ProductName, price) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, orderId);
			pstmt.setString(2, storeId);
			pstmt.setString(3, prductId);
			pstmt.setString(4, productName);
			pstmt.setString(5, price);
			
			pstmt.executeUpdate();
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	//get StoreId of given product
	
	public static String getStoreIdOfParticularProduct(Connection conn, String productId) throws SQLException {
		
		String storeId = "";
		
		String sql = "SELECT * FROM testproducts tp WHERE tp.productId = '"+productId+"' ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	storeId = rs.getString("storeId");

		        }
		 }
		
		return storeId;
         
       
		
	}
	
	
	
	//get price of given product
	
	public static String getPriceOfParticularProduct(Connection conn, String productId) throws SQLException {
		
		String price = "";
		
		String sql = "SELECT * FROM testproducts tp WHERE tp.productId = '"+productId+"' ";

		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	price = rs.getString("price");

		        }
		 }
		
		return price;
         
       
		
	}
	
	
	//insert into my downloads
	public static void insertIntoMyDownloads(Connection conn, String paidUsername, String paidProductId) {
		
		String sql = "INSERT INTO mydownloads (paidUsername, paidProductId) VALUES (?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, paidUsername);
			pstmt.setString(2, paidProductId);
			
			pstmt.executeUpdate();
			
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	//Display Download accessed (purchased) products from my download table
	
	public static String fetchMyDownloadsProducts(Connection conn, String loggedUsername) throws SQLException {
		
		String output = "";
		String sql = "SELECT * FROM mydownloads WHERE paidUsername = '"+loggedUsername+"' ";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		        	
		        	String paidProductId = rs.getString("paidProductId");
		        	
		        	String sql2 = "SELECT * FROM testproducts WHERE productId = '"+paidProductId+"' ";
		        	
		        	
		        	
				        	try (PreparedStatement stmt2 = conn.prepareStatement(sql2);
				   		         ResultSet rs2 = stmt2.executeQuery()) {
		
				   		        while (rs2.next()) {
				   		        	
				   		        	String productName = rs2.getString("name");
				   		        	String shortDescription = rs2.getString("sDesc");
				   		        	String productPrice = rs2.getString("price");
				   		        	String downloadLink = rs2.getString("downloadLink");
				   		        	
				   		        	
				   		        	output += "<li class=\"list-group-item\">\r\n" + 
				   		        			"          <!-- Custom content-->\r\n" + 
				   		        			"          <div class=\"media align-items-lg-center flex-column flex-lg-row p-3\">\r\n" + 
				   		        			"            <div class=\"media-body order-2 order-lg-1\">\r\n" + 
				   		        			"              <h5 class=\"mt-0 font-weight-bold mb-2\"> "+productName+" </h5>\r\n" + 
				   		        			"              <p class=\"font-italic text-muted mb-0 small\"> "+shortDescription+" </p>\r\n" + 
				   		        			"              <div class=\"d-flex align-items-center justify-content-between mt-1\">\r\n" + 
				   		        			"                <h6 class=\"font-weight-bold my-2\">$ "+productPrice+".00 </h6>\r\n" + 
				   		        			"                <ul class=\"list-inline small\"> <a href= "+downloadLink+" target='_blank'>Click to download</a> \r\n" +
				   		        								
				   		        			"                </ul>\r\n" + 
				   		        			"              </div>\r\n" + 
				   		        			"            </div><img src=\"https://res.cloudinary.com/mhmd/image/upload/v1556485076/shoes-1_gthops.jpg\" alt=\"Generic placeholder image\" width=\"200\" class=\"ml-lg-5 order-1 order-lg-2\">\r\n" + 
				   		        			"          </div>\r\n" + 
				   		        			"          <!-- End -->\r\n" + 
				   		        			"        </li>";
				   		        	
				   		        	
				   		        }
				   		 }
		        	
		        	
		        	
		        	
		        	
		        }
		 }
		
		return output;
		
	}
	
	
	//Increment sales count on payment success page
	public static void incrementSalesCountAfterPaymentSuccess(Connection conn, String paidProductId) throws SQLException {
		
		String sql = "UPDATE testproducts SET sales = sales + 1 WHERE productId = '"+paidProductId+"' ";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);
		preparedStmt.executeUpdate();
		
	}
	
	

}
