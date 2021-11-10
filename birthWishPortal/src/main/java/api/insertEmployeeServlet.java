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
@WebServlet("/insertEmployeeServlet")
@MultipartConfig
public class insertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private collector dataCol = new collector();
       
   
    public insertEmployeeServlet() {
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
	        
			//String emp_id = request.getParameter("emp_id");
	        String name = request.getParameter("name");
	        String bdate = request.getParameter("bdate");
	        String designation = request.getParameter("designation");
	        String message = request.getParameter("message");
	        String email = request.getParameter("email");	
	        Part filePart = request.getPart("uploadfile");
	    	String fileName = filePart.getSubmittedFileName();
			
	        System.out.println("file Name " + fileName);
	      
			
		   File file = new File("/home/birthday/"+fileName);
			   
				System.out.println("path" +file);
				
				InputStream ins = filePart.getInputStream();

				byte[] bytes = new byte[ins.available()];
				ins.read(bytes);

				FileOutputStream fis = new FileOutputStream(file);
				fis.write(bytes);
				out.flush();
				fis.close();
			
			//response.getWriter().print("The file uploaded sucessfully.");

			String img_url = "/home/birthday/"+fileName;

			if (img_url != null) {

            int count = 0;
				
	        	try
	        	{
	        	
        	count =   dataCol.insertInfo(name, bdate, designation, message, email, img_url );
	        	
				if(count>0)
				{
					
					
					 out.println("<script>alert('Information Uploaded ') </script>");
					 RequestDispatcher rss = request.getRequestDispatcher("viewEmployee.jsp");
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

	}


