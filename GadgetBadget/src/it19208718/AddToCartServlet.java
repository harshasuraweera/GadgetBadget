package it19208718;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String productId = request.getParameter("productId");
    	String productName = request.getParameter("productName");
    	String productPrice = request.getParameter("productPrice");
    	String shortDescription = request.getParameter("shortDescription");
    	String defaultQuantity = request.getParameter("defaultQuantity");
    	String loggedUsername = request.getParameter("loggedUsername");
    	
		
		Connection conn = PaymentServiceDBConnection.getConnection();
		
		Queries.addToCart(conn, loggedUsername, productId, productName , shortDescription, defaultQuantity, productPrice);
		
		
	}

}
