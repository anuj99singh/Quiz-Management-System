

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class waste1
 */
@WebServlet("/waste1")
public class waste1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int i=Integer.parseInt(request.getParameter("t0"));
		if(i==1) {
			RequestDispatcher r=request.getRequestDispatcher("quiz_s.html");
			r.include(request, response);
		}
		else if(i==2) {
			RequestDispatcher r=request.getRequestDispatcher("quiz update karan ");
			r.include(request, response);
		}
		else if(i==3) {
			RequestDispatcher r=request.getRequestDispatcher("quiz_view.jsp");
			r.forward(request, response);
		}
		
	}

	

}
