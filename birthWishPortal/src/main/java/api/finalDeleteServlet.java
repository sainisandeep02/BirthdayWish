package api;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Map;
import java.io.File;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.JSONObject;


import services.collector;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/finalDeleteServlet")
@MultipartConfig
public class finalDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private collector dataCol = new collector();
       
   
    public finalDeleteServlet() {
        super();
      
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        HttpSession session = request.getSession();
			String username = (String) session.getAttribute("user");
			System.out.println("Username "+username);
			try 
			{
			String emp_id  = request.getParameter("emp_id");

            int count = 0;

        	count =   dataCol.deleteInfo(emp_id);
	        	
				if(count>0)
				{
					 out.println("<script>alert('Information Deleted ') </script>");
					 RequestDispatcher rss = request.getRequestDispatcher("index.jsp");
					   rss.include(request, response);
				      return;
				}
	        	
				else
				{
				   out.println("Something went wrong");
				   RequestDispatcher rss = request.getRequestDispatcher("login.jsp");
				   rss.include(request, response);
				
				
	        	}
			}
	          catch (Exception e) {
			
				e.printStackTrace();
			}
			}
}


