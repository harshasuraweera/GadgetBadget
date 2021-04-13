package it19207896;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ProductServiceDBConnection;

/**
 * Servlet implementation class DeleteProductsServlet
 */
@WebServlet("/DeleteProductsServlet")
public class DeleteProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = request.getParameter("productId");
		Connection connection = ProductServiceDBConnection.getConnection();
		
		Queries_2.deleteProducts(connection, productId);
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("/my-store.jsp");
		dispatcher.forward(request, response);
		
	}

}
