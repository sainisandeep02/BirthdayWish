package api;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
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

import services.collector;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/viewEmployeeServlet")
@MultipartConfig
public class viewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private collector dataCol = new collector();
       
   
    public viewEmployeeServlet() {
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
	        
			
			if (username != null) {
            ResultSet rs;
				
	        	try
	        	{
	        	
        	    rs =   dataCol.viewRecords();
	           
				}
	        
	          catch (Exception e) {
			
				e.printStackTrace();
			}
	        
	}
}

	}


