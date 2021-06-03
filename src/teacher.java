

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import code.ABC;
/**
 * Servlet implementation class teacher
 */
@WebServlet("/teacher")
public class teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
	      String u=request.getParameter("t5");
         String p=request.getParameter("t6");
	      if(u.equals("anuj") &&  p.equals("anuj")) {
	    	  
	    	  Cookie ck=new Cookie(u,p);
	    	  response.addCookie(ck);
	    	  
	    	  out.print("<h1>SUCCESSFULL LOGIN</h1>");
	    	  RequestDispatcher x=request.getRequestDispatcher("teacher_choice.html");
	    	  x.include(request, response);
	    	  
	      }
	      else {
	    	  out.print("<h1>INCORRECT PASSWORD</h1>");
	    	  RequestDispatcher x=request.getRequestDispatcher("teacher_auth.html");
	    	  x.include(request, response);
	      }
		 
		


}
	}
