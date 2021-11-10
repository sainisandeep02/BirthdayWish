<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="api.logoutServlet"%>

<%
    String errorMessage=(String)request.getAttribute("errorMessage");
        if(errorMessage !=null){
        	out.println("<script type=\"text/javascript\">");
		       out.println("alert('User or password incorrect');");
		       out.println("</script>");
        	response.sendRedirect("login.jsp");
        	
        	return;
      
        }
%>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    
    <link rel="stylesheet" href="js/custom.js">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;700&family=Jost:wght@200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <style>
        body{
            font-family: 'Jost', sans-serif;
            color: #fff;
        }
        h1, h2, h3, h4, h5{
            font-family: 'DM Sans', sans-serif;
        }
        .body_wrapper{
            background-image: url('images/bg-kids.jpg');
            background-size: contain;
            background-position: center;
        }
        .body_wrapper:before {
            content: '';
            backdrop-filter: blur(1px);
            background-color: rgba(0,0,0,.1);
            position: absolute;
            left: 0;
            top: 0;
            height: 100%;
            width: 100%;
            pointer-events: none;
            /* background: linear-gradient(90deg, rgb(0 0 0 / 10%), transparent); */
        }
        .logo img{
            height: 110px;
        }
        .left_content .cusform {
            background-color: rgb(255 255 255 / 88%);
            padding: 40px 38px 42px;
            border-radius: 15px;
            backdrop-filter: blur(11px);
            -webkit-backdrop-filter: blur(11px);
            box-shadow: 0 .125rem 15px rgba(0,0,0,.15);
            color: #000;
        }
        .left_content h2 {
            font-size: 36px;
            margin-bottom: 1px;
        }
        .left_content h4 {
            margin-bottom: 20px;
            font-size: 18px;
            font-weight: normal;
        }
        .left_content .cusform .form-group label {
            font-size: 14px;
            margin-bottom: 5px;
            letter-spacing: .5px;
        }
        .left_content .cusform .form-group input.form-control {
            border-color: #fff;
            border-radius: 7px;
            min-height: 46px;
            padding: 5px 19px;
            border: 2px solid #ddd;
        }
        .submit-btn .btn{
            font-size: 14px;
            letter-spacing: .5px;
            min-width: 150px;
            min-height: 45px;
        }
        @media screen and (max-width:991px){
            .body_wrapper {
                background-size: cover;
                background-position: center;
            }
        }
        @media screen and (max-width:767px){
            .left_content h2 {
                font-size: 22px;
                text-align: center;
            }
            .left_content h4 {
                font-size: 16px;
                text-align: center;
            }
            .left_content .cusform {
                backdrop-filter: blur(6px);
                -webkit-backdrop-filter: blur(6px);
            }
            .logo img {
                height: 120px;
            }
        }
        @media screen and (max-width:575px){
            .left_content h2 {
                font-size: 20px;
            }
            .left_content .cusform {
                padding: 25px 18px 30px;
            }
            .left_content .cusform .form-group input.form-control {
                padding: 5px 14px;
                min-height: 43px;
                background-color: #fff;
            }
            .submit-btn .btn {
                width: 100%;
                letter-spacing: 1px;
                font-weight: 500;
            }
        }
    </style>
</head>
<body>
    <main>
        <div class="body_wrapper">
            <div class="container">
                <div class="row py-3 py-md-5 min-vh-100 align-items-center justify-content-center">
                    <div class="col-md-7 col-lg-6 col-xl-5">
                        <div class="left_content">
                            <div class="cusform">
                                <!-- <div class="logo mb-2 text-center">
                                    <a href="#"><img src="images/logo.png" alt="Logo" class="img-fluid" /></a>
                                </div> -->
                                <h2 class="text-dark">Log In</h2>
                                <h4>Birthday Wishes Portal</h4>
                                <form action = "loginServlet" method ="post">
                               
                                <div class="form-group mb-3">
                                    <label for="">ENTER YOUR USERNAME </label>
                                    <input type="text" name="username" class="form-control" id="username" placeholder="Enter your username " required>
                                </div>
                                 <div class="form-group mb-3">
                                    <label for="">ENTER YOUR PASSWORD</label>
                                    <input type="password" name="password" class="form-control" id="password" placeholder="Enter your Password " required>
                                </div>
                             <!--    <div class="form-check mb-3">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault"> I agreed to the <a href="#" class="text-dark">Terms and Conditions </a></label>
                                </div> -->
                                <div class="submit-btn">
                                    <button type="submit" onclick="login()" class="btn px-4 text-uppercase btn-primary submit-btn-cus" id="btn">Join</button>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- <div class="col-md-6">
                        <img src="images/right-img.png" alt="game" class="img-fluid" />
                    </div> -->
                </div>
            </div>
        </div>
    </main>
    <script type="text/javascript">
    function login(){
    	
               let username= document.getElementById("username").value;
               let password= document.getElementById("password").value;
               
   						if (username == "") {

							alert('Please put Your Username!');
							return;
   						}else if(password=="")
   							{
   							alert('Please put Password !');
							return;
   							}
					}
				</script>
     <script src ="" ></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>