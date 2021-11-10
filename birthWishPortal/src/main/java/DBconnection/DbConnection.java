package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	
	
	public static Connection getDb() {
		
		Connection conn=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		    conn=DriverManager.getConnection("jdbc:mysql://91.205.172.123:3306/birth?autoReconnect=true&enabledTLSProtocols=TLSv1.2&serverTimezone=UTC","root","gloadmin123");
		  //conn=DriverManager.getConnection("jdbc:mysql://5.189.146.57/test?autoReconnect=true&enabledTLSProtocols=TLSv1.2&serverTimezone=UTC","root","genr@&y&123");
			//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/birth?autoReconnect=true&enabledTLSProtocols=TLSv1.2&serverTimezone=UTC","root","gloadmin123");
			System.out.println("Connected......");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;		
		
	}

}
