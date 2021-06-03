

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class check
 */
@WebServlet("/check")
public class check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		int i=Integer.parseInt(request.getParameter("t0"));
		if(i==1) {
			RequestDispatcher rd= request.getRequestDispatcher("stu_form_fling.html");
			rd.forward(request, response);
		}
		
		else if(i==2) {
			RequestDispatcher r= request.getRequestDispatcher("teacher_auth.html");
			r.forward(request, response);
		}
	
	}

	

}
