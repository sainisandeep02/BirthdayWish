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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private collector dataCol = new collector();
       
   
    public loginServlet() {
        super();
      
    }

	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
    	resp.sendRedirect("login.jsp");
    	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        HttpSession session=request.getSession();
	        
	    	if (username == null || password == null) {

				response.sendRedirect("login.jsp");
				return;
	        
	    	}
	    	else {
	        	try 
	        	{
	        	ResultSet rs  =   dataCol.checkUser(username, password);
					int count=0;
					while (rs.next())
					{
						session.setAttribute("user", username);
						 count=rs.getInt(1);
					}
	        	
	        	
					if(count>0)
					{
						RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
						return;
					}
					
//					else {
//						response.sendRedirect("landing.jsp");
//						return;
//					}

	        
				else
				{
					
					System.out.println("incorrect username");
				   out.println("Username or Password incorrect");
				   out.println("<script type=\"text/javascript\">");
			       out.println("alert('User or password incorrect');");
			       out.println("</script>");
//					
//					response.sendRedirect("login.jsp");
//					return;
//				   
				}
				
	        }
	          catch (Exception e) {
			
				e.printStackTrace();
			}
	}
}
}
	


