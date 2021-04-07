package it19208718;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFromCart() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cartId = request.getParameter("cartId");
		Connection conn = PaymentServiceDBConnection.getConnection();
		
		Queries.deleteFromCart(conn, cartId);
		
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/cart.jsp");
		RequetsDispatcherObj.forward(request, response);
		
		
		
	}

}
