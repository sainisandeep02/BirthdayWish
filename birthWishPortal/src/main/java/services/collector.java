package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import api.Loader;

public class collector {
	
	
	public ResultSet checkUser (String username, String password)
	{
		String query = "";
		ResultSet rs = null;
		try 
		{      
		query = "SELECT count(1), username,password FROM birthdaylogin WHERE username= ? and password = ?";
		PreparedStatement ps= Loader.con.prepareStatement(query);
		
		ps.setString(1, username);
		ps.setString(2, password);
	    
		System.out.println (ps);
	    rs = ps.executeQuery();
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return rs;
		

}
	
	
	public int insertInfo (String name, String bdate, String designation, String message, String email, String img_url)
	{
		String query = "";
		ResultSet rs = null;
		int count = 0;
		try 
		{
			
		query = "insert into birthday (name, date_of_birth, designation, message, to_mail, image_url) values" 
		+ "('"+name+"','"+bdate+"','"+designation+"','"+message+"','"+email+"','"+img_url+"')";
		
		PreparedStatement ps= Loader.con.prepareStatement(query);
	    
		System.out.println (query);
	    count = ps.executeUpdate();
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return count;
		

}
	

	public ResultSet allRecords () 
	{
		ResultSet rs = null ;
		
		try {

     	  String query = "SELECT * FROM birthday"; 
	     
	      PreparedStatement pst = Loader.con.prepareStatement(query);
	       rs = pst.executeQuery();
	     
		}
			catch (Exception e) {
				e.printStackTrace();

			}
	  
			return rs;
		}

	
	
	
	public static JSONArray selectRecords(String emp_id) {

		JSONArray jarr = new JSONArray();
		ResultSet rs = null ;
		try {

			String query = "SELECT * FROM birthday where emp_id ='"+emp_id+"' ";
			 PreparedStatement ps = Loader.con.prepareStatement(query);
		       rs = ps.executeQuery();
			
			
			String ename;
			String date_of_birth;
			String designation;
			String message;
			String to_mail;
			String image_url;
			
			
			while (rs.next()) {
				JSONObject js = new JSONObject();
				ename = rs.getString("name");
				date_of_birth= rs.getString("date_of_birth");
				designation= rs.getString("designation");
				message = rs.getString("message");
				to_mail = rs.getString("to_mail");
				image_url = rs.getString("image_url");
				
				js.put("ename", ename);
				js.put("date_of_birth", date_of_birth);
				js.put("designation", designation);
				js.put("message", message);
				js.put("to_mail", to_mail);
				js.put("image_url", image_url );
				jarr.put(js);
				
			}
		} 
		catch (Exception e) {
			e.printStackTrace();

		}
        System.out.println("jarr "+jarr.toString());
		return jarr;
	}

	


	  public int updateInfo (String emp_id, String name, String bdate, String designation, String message, String email, String img_url)
	  { 
		  int i =0; 
		  String query ="";
		  	try
		  	{
		  		
		  	query = "update birthday set name ='"+name+"', date_of_birth ='"+bdate+"', designation ='"+designation+"',"
		  			+ " message ='"+message+"', to_mail ='"+email+"', image_url='"+img_url+"' where emp_id='"+emp_id+"'";
		  		
		
		  		PreparedStatement ps = Loader.con.prepareStatement(query);
		  	
		  		
		  		System.out.println (query); 
		  		i = ps.executeUpdate();

		  	} 
		  	catch (Exception e) 
		  	{
		  		e.printStackTrace(); 
		  	} 
		  	return i; 
		  	}
	  

	  public int deleteInfo (String emp_id)
	  { 
		  int i =0; 
		  String query ="";
		  	try
		  	{
		  		
		  	query = "delete from birthday where emp_id='"+emp_id+"'";
		  		
		
		  		PreparedStatement ps = Loader.con.prepareStatement(query);
		  	
		  		
		  		System.out.println (query); 
		  		i = ps.executeUpdate();

		  	} 
		  	catch (Exception e) 
		  	{
		  		e.printStackTrace(); 
		  	} 
		  	return i; 
		  	}
	

	  
	  public ResultSet viewRecords () 
	  { 
	  String query = "SELECT * FROM birthday"; 
	  ResultSet rst = null;
	  try
	  {
		  	 
	  PreparedStatement pst = Loader.con.prepareStatement(query);
	  rst = pst.executeQuery();
	  
	  }
	  
	  catch (Exception e)
	  { 
		  e.printStackTrace();

	  }
		return rst;
	  }	
	
	  
	  public int insertFestivalInfo (String festname, String fdate, String message, String img_url)
		{
			String query = "";
			ResultSet rs = null;
			int count = 0;
			try 
			{
				
			query = "insert into festival (festName, date_of_fest, message, image_url) values" 
			+ "('"+festname+"','"+fdate+"','"+message+"','"+img_url+"')";
			
			PreparedStatement ps= Loader.con.prepareStatement(query);
		    
			System.out.println (query);
		    count = ps.executeUpdate();
			}
			
			catch (Exception e) {
				e.printStackTrace();
				
			}
			return count;
			

	}
	  
}

