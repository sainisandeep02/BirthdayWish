<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "api.loginServlet" %>
<!DOCTYPE html>

<%
    String username=(String)session.getAttribute("user");
        if(username==null){
        	response.sendRedirect("login.jsp");
        	return;
      
        }
%>

<html lang="en">
<head>
  <title>Birthday Wish Portal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">	
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
  
   <li class="nav-item active">
      <a class="nav-link " href="index.jsp">Home</a>
    </li>
    <li class="nav-item active">
      <a class="nav-link " href="view.jsp">View all Employees</a>
    </li>
   
  </ul>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
 <!--  Write somthing  -->
    </div>
    
    <div class="col-sm-8 text-left"> 
      
      <form action ="logoutServlet" method ="post" >
      

     <div class="form-group">
      <label for="sure">Are you sure to log out</label>
     
    </div> 


    <button type="submit" class="btn btn-primary">Log Out</button>
    
    
  </form>
      
   
    
    </div>
    
    
    <div class="col-sm-2 sidenav">
		     <!--write Ssomething  -->
    </div>
    
  </div>
</div>

<!-- <footer class="container-fluid text-center"> -->
<!--   <p>Footer Text</p> -->
<!-- </footer> -->

</body>
</html>



