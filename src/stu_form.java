

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.ABC;

/**
 * Servlet implementation class stu_form
 */
@WebServlet("/stu_form")
public class stu_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
            PrintWriter out = response.getWriter(); 
            Connection con = ABC.initializeDatabase(); 
            int s1=Integer.parseInt(request.getParameter("t1"));
        	java.sql.Statement stmt = con.createStatement();    
        	out.print("done 1");
            ResultSet rs = stmt.executeQuery("select * from student");
            int flag=0;
            out.print("done 2");
            
			while(rs.next()) {
				out.print("done 3");
				if(Integer.parseInt(rs.getString("id"))==s1) {
					flag=1;
					out.print("done 4");
				break;
			}
		    
			}
			if(flag==0) {
				out.print("done6");
				PreparedStatement st = con.prepareStatement("insert into student values(?,?,?)");
				 st.setInt(1, s1); 
				  
		            // Same for second parameter 
		            st.setString(2, request.getParameter("t2")); 
					int x=0;
					st.setInt(3,x);
					st.executeUpdate();
					out.print("done 7");
			}
			else {
				out.print("<h1>you already given the exam and your result is</h1>");
				String n = rs.getString("result");
       			out.print(n);
			}
            
		}
		 catch (Exception e) { 
	            PrintWriter out = response.getWriter(); 

	        	out.println(e);
	        } 
	}

	
}
