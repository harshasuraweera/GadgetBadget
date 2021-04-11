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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String storeId = request.getParameter("storeId");
		String projectId = RequiredMethod.generateProductId();
		String title = request.getParameter("title");
		String sDesc = request.getParameter("sDesc");
		String lDesc = request.getParameter("lDesc");
		String price = request.getParameter("price");
		String downloadLink = request.getParameter("downloadLink");
		String feturedImage = request.getParameter("feturedImage");
		
		Connection connection = ProductServiceDBConnection.getConnection();
		
		Queries_2.addProduct(connection,projectId,title, sDesc, lDesc, price, downloadLink,feturedImage);
		
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("/add-products.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
