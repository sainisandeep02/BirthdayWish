package api;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import DBconnection.DbConnection;

/**
 * Servlet implementation class Loader
 */
public class Loader extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public static Connection con=null;
    public Loader() {
        super();
       
    }
    
    

	@Override
	public void init() throws ServletException {
		
		con=DbConnection.getDb();
		super.init();
	}
}
