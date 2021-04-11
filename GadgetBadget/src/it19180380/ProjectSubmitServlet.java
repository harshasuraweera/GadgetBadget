package it19180380;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProjectSubmitServlet")
public class ProjectSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 public ProjectSubmitServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String RandomprojectID   = GenerateProjectID.generateProjectId();
		String ShortDes   = request.getParameter("ShortDes");
		String LongDes   = request.getParameter("LongDes");
		String srcLink   = request.getParameter("srcLink");
		String videoLink   = request.getParameter("videoLink");
	
		
		boolean isTrue;
		
		isTrue = ProjectDbUtil.submitProjects( title, RandomprojectID, ShortDes, LongDes, srcLink, videoLink);
		
		if(isTrue == true)
		{
			RequestDispatcher dis = request.getRequestDispatcher("AddProject-Success.jsp");
			dis.forward(request, response);
		}else {
			
			RequestDispatcher dis2 = request.getRequestDispatcher("AddProject-Unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
