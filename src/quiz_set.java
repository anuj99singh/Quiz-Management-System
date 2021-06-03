

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

import code.ABC;

/**
 * Servlet implementation class quiz_set
 */
@WebServlet("/quiz_set")
public class quiz_set extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//static int x;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{
		    
		
		try {
			 
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Connection con = ABC.initializeDatabase();
			//int x=0;
			//if (x==0) {
			//java.sql.Statement stmt = con.createStatement();
			
			//ResultSet rs = stmt.executeQuery("DELETE FROM exam;");
			//x=1;
			//}
			PreparedStatement st = con.prepareStatement("insert into exam(question,options,correctoption) values(?,?,?)");
			
		
				
				
				st.setString(1,(request.getParameter("t5")));
				
				st.setString(2,(request.getParameter("t6")));
				
				st.setString(3,(request.getParameter("t7")));
				
				
			
				st.executeUpdate();
				
				
				out.print("NEXT QUESTION");
				
		
				RequestDispatcher r=request.getRequestDispatcher("quiz_s.html");
				r.include(request, response);
				
			}
		
  			catch (Exception e) { 
  				PrintWriter out = response.getWriter();
  				out.print(e.getMessage());
			
			
			}
	}

}
