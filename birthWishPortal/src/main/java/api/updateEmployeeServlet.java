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
@WebServlet("/updateEmployeeServlet")
@MultipartConfig
public class updateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private collector dataCol = new collector();
       
   
    public updateEmployeeServlet() {
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
			
			String action = request.getParameter("action");
			System.out.println("action is "+action);
			try {
			if (action.equalsIgnoreCase("1")) 
			{
				
			String emp_id  = request.getParameter("emp_id");
         
			JSONObject js = new JSONObject();
			js.put("empdata", collector.selectRecords(emp_id));
			System.out.println("data retured to servlet");
			out.print(js.toString());
			return;
            }
		
			}
	          catch (Exception e) {
			
				e.printStackTrace();
			}
			}
	
}

