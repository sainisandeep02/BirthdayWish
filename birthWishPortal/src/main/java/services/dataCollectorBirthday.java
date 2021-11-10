package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class dataCollectorBirthday {
	
	public static void main(String[] args) {
		 String name="";
		 String msg="";
		 String to_mail = "";
		 String image_url ="";
		try
		{	  
			dataCollectorBirthday doc = new dataCollectorBirthday();
		    ResultSet rs;
			rs = getBirthday();
			while (rs.next())
			{
		       name = rs.getString("name");
		       msg = rs.getString("message");
		       to_mail = rs.getString("to_mail");
		       image_url = rs.getString("image_url");
		    System.out.println("hello "+name +" "+msg);
		    System.out.println("Image URL : "+image_url);
			sendBirthdayEmail (name, msg, to_mail, image_url);
		}
			
		   ResultSet rsst;
		   rsst = getFestival();
		   while (rsst.next())
           {
        	 String festname = rsst.getString("festName");
        	 String  message = rsst.getString("message");
        	 String img_url = rsst.getString("img_url");
        	 System.out.println("festival name = "+festname +" "+message+ " "+img_url);
        	 sendFestivalEmail (festname, message, img_url);
           }
		}
		
		catch(Exception e){  
			
			e.printStackTrace();
	}
	}
	
public static Connection getDb() {
		
		Connection conn=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
   		    conn=DriverManager.getConnection("jdbc:mysql://91.205.172.123:3306/birth?autoReconnect=true&enabledTLSProtocols=TLSv1.2&serverTimezone=UTC","root","gloadmin123");
			//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gameomania?autoReconnect=true&enabledTLSProtocols=TLSv1.2&serverTimezone=UTC","root","gloadmin123");
			System.out.println("Connected to birthday......");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static ResultSet getBirthday() {
		
		ResultSet rs = null;
		String query = "";
		try {
			
			query = "SELECT * FROM birthday WHERE DATE_FORMAT(date_of_birth, '%m-%d') = DATE_FORMAT(NOW(), '%m-%d')";
			PreparedStatement ps = getDb().prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println("query is "+query);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static void sendBirthdayEmail (String name, String message, String to_mail, String image_url)
	{
	System.out.println("image url in mail main method" +image_url);
	
	final String username = "hr@visiontrek.in";
	final String password = "hRa@2014$145";
	String fromMail = "hr@visiontrek.in";
	
//	  final String username = "sandeep.kaur@visiontrek.in";
//      final String password = "Sandpee!32rfsfgBrhtf";
//	  String fromMail = "sandeep.kaur@visiontrek.in";
	
	Properties properties = new Properties();
	properties = System.getProperties();
	System.out.println("properties  "+properties);
	
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "mail.eoutlooks.com");
	properties.put("mail.smtp.port", "587");
	
	Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
		
	}
	
	});
	
	MimeMessage msg = new MimeMessage(session);
	try
	{
		msg.setFrom(new InternetAddress(fromMail));
		
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_mail));
		msg.addRecipient(Message.RecipientType.CC, new InternetAddress("team@visiontrek.in"));
		
		msg.setSubject("Happy birthday "+name);
		
		MimeMultipart multipart = new MimeMultipart();
		
		MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        String htmlText1 = "<H1>"+message+"</H1><img src=\"cid:image\">";
        messageBodyPart1.setContent(htmlText1, "text/html");
        multipart.addBodyPart(messageBodyPart1);
        
        // second part (the image)
        messageBodyPart1 = new MimeBodyPart();
        DataSource fds = new FileDataSource(image_url);
        messageBodyPart1.setDataHandler(new DataHandler(fds));
        messageBodyPart1.setHeader("Content-ID", "<image>");
        multipart.addBodyPart(messageBodyPart1);
       
       
        msg.setContent(multipart);
		
		
		Transport.send(msg);
		
		System.out.println("message sent");
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
	}
	
	
public static ResultSet getFestival() {
		
		ResultSet rs = null;
		String query = "";
		try {

			query = "SELECT * FROM festivals WHERE DATE_FORMAT(date_of_fest, '%m-%d') = DATE_FORMAT(NOW(), '%m-%d')";
			PreparedStatement ps = getDb().prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println("query is "+query);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	

		public static ResultSet getToMail() {
			
			ResultSet rs = null;
			String query = "";
			try {
				
				query = "SELECT * FROM allmail";
				PreparedStatement ps = getDb().prepareStatement(query);
				rs = ps.executeQuery();
				System.out.println("query is "+query);
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
    
     
     public static void sendFestivalEmail (String festname, String message, String img_url)
       {
    	 
           System.out.println("image url in mail main method  " +img_url);

          final String username = "hr@visiontrek.in";
          final String password = "hRa@2014$145";
          String fromMail = "hr@visiontrek.in";
          
//          final String username = "sandeep.kaur@visiontrek.in";
//          final String password = "Sandpee!32rfsfgBrhtf";
//          String fromMail = "sandeep.kaur@visiontrek.in";
         
          try
			{
				 ResultSet rs;
				 String to_mail ="";
				 rs = getToMail();
					while (rs.next())
					{
				       to_mail = rs.getString("to_mail");
				       System.out.println("to mail "+to_mail);
			
        
                Properties properties = new Properties();
				properties = System.getProperties();
				//System.out.println("properties  "+properties);
				
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.enable", "true");
				properties.put("mail.smtp.host", "mail.eoutlooks.com");
				properties.put("mail.smtp.port", "587");
				
				Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
					
				}
				
				});
				
				
				    MimeMessage msg = new MimeMessage(session);
					
					msg.setFrom(new InternetAddress(fromMail));
					
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_mail));
					
					msg.setSubject("Happy "+festname);
					
					MimeMultipart multipart = new MimeMultipart();
					
					MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			        String htmlText1 = "<H1>"+message+"</H1><img src=\"cid:image\">";
			        messageBodyPart1.setContent(htmlText1, "text/html");
			        multipart.addBodyPart(messageBodyPart1);
			        
			        // second part (the image)
			        messageBodyPart1 = new MimeBodyPart();
			        DataSource fds = new FileDataSource(img_url);
			        messageBodyPart1.setDataHandler(new DataHandler(fds));
			        messageBodyPart1.setHeader("Content-ID", "<image>");
			        multipart.addBodyPart(messageBodyPart1);
			       
			        msg.setContent(multipart);
					
					Transport.send(msg);
					
					System.out.println("message sent");
				}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				}
		
}
	
