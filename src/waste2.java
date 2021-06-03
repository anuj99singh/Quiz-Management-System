

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class waste2
 */
@WebServlet("/waste2")
public class waste2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public waste2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//float x=Float.parseFloat(request.getParameter("questionr"));
        String mn=request.getParameter("questionr");
        
        out.print(mn);
		HttpSession session = request.getSession();
		session.setAttribute("qo", mn);
		
       
        
    	RequestDispatcher rd=request.getRequestDispatcher("update.html");
		rd.forward(request, response);
	}

	

}
