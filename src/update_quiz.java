

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import code.ABC;

/**
 * Servlet implementation class update_quiz
 */
@WebServlet("/update_quiz")
public class update_quiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_quiz() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		 try {
			Connection con = ABC.initializeDatabase();
			
			HttpSession session = request.getSession(false);
			String k = (String) session.getAttribute("qo"); 
			
			String array[]=k.split("");//  11 this is india 
			
			
			int jh=Integer.parseInt(array[1]);
			
		
			
			//out.println(g + "  "+k+"  "+m);
			if(jh==1 ){
			PreparedStatement st = con.prepareStatement("update exam set question=? where qno=?");
			
            st.setString(1, request.getParameter("t")); 
            st.setInt(2, Integer.parseInt(array[0])); 
            out.println("gg2");
            st.executeUpdate();
            
            RequestDispatcher r=request.getRequestDispatcher("quiz_view.html");
			r.include(request, response);

			}
			if(jh==2) {
				PreparedStatement st = con.prepareStatement("update exam set options=? where qno=?");
				
	            st.setString(1, request.getParameter("t")); 
	            st.setInt(2, Integer.parseInt(array[0]));
	            st.executeUpdate(); 
	            RequestDispatcher r=request.getRequestDispatcher("quiz_view.html");
				r.include(request, response);
			}
			

//			
		} 
		 catch(Exception e)
		 {
			 out.print(e);
		 }
	}

}
