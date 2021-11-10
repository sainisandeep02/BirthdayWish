package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import services.collector;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public logoutServlet() {
        super();
      
    }

	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
    	
    	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        HttpSession session=request.getSession();
	    
	         session.invalidate();  
	              
            //out.print("You are successfully logged out!");  
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Log Out</title>");
            out.println("<body bgcolor ='pink'>");
            out.print("<h1><center>You are successfully logged out!</center></h1>"); 
            out.print("<a href='login.jsp'>Login Again</a>");
            out.println("</body>");
            out.println("</html>");   
            
            
	        }
	         
	
}



