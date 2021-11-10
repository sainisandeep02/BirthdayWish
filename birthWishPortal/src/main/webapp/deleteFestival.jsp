<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="services.collector"%>
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
<!-- <script type="text/javascript" src="js/birthdayCustom.js"></script> -->
 
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
      <a class="nav-link" href="index.jsp">Home</a>
    </li>
    
 
    <li class="nav-item active">
      <a class="nav-link" href="view.jsp">View all Employees</a>
    </li>
    
   
    <li class="nav-item active">
      <a class="nav-link" href="logout.jsp">Log Out</a>
    </li>
  </ul>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
 <!--  Write somthing  -->
    </div>
    
    <div class="col-sm-8 text-left"> 
      
 <form method="post" action="finalDeleteServlet" enctype="multipart/form-data">
   
    
    <h2>Delete record</h2>
    <div class="form-group">                                                             
		<label for="emp_id">Select a Employee ID :</label> <select name="emp_id" onchange="birthdayDelete(this.value)">
		<%
			collector col = new collector();
			ResultSet rs = col.allRecords();
		
			while (rs.next()) {
				String emp_id = rs.getString("emp_id");
				
			%>
		
		<option value="<%=emp_id%>"><%=emp_id%></option><br>
 
			<%
				}
			%>
			   </select>
	</div>
   
    <div class="form-group">
      <label for="name">Name:</label>
      
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" required>
    </div>
   
    
     <div class="form-group">
      <label for="bdate">Date Of Birth:</label>
      <input type="date" class="form-control" id="bdate" placeholder="Enter Date of birth" name="bdate">
    </div>
    
     <div class="form-group">
      <label for="designation">Designation:</label>
      <input type="text" class="form-control" id="designation" placeholder="Enter Designation" name="designation">
    </div> 

    <div class="form-group">
      <label for="birthday_message"> Birthday Message:</label>
       <input type="text" class="form-control" id="message" placeholder="Enter message to send" name="message">
    </div>
     
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    
    
    <div class="form-group">
      <label for="image_send">Image to send:</label>
      <input type="file" class="form-control" id="uploadfile" name="uploadfile">
    </div>

   
    <button type="submit" class="btn btn-primary">Delete</button>
   
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
<script type="text/javascript">
async function birthdayDelete(emp_id) {

	let html = '';
	let deletename='';
	//let emp_id = document.getElementById("emp_id").value;
	
	console.log("emp_id" +emp_id);
	
	let rdata = {
		"emp_id" : emp_id
	};
	console.log("requested data"+rdata);
	let query = new URLSearchParams(rdata);

	await fetch('deleteServlet?action=2', 
	      { 
		  method: 'post',
		  body: query
          }).then(resp => { return resp.json() })
           .then(data => {
		
		let pro = data.empdata;
		console.log(...pro);
		console.log("data retured");
		
		pro.forEach(name => {
			
            document.getElementById("name").value = name.ename;
            document.getElementById("bdate").value = name.date_of_birth;
            document.getElementById("designation").value = name.designation;
            document.getElementById("message").value = name.message;
            document.getElementById("email").value = name.to_mail;
            document.getElementById("uploadfile").value = name.image_url;
									
		});
		service.insertAdjacentHTML('afterbegin', html);

	}).catch(erorr => console.log(erorr));
}



</script>
</html>



