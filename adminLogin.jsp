<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	

		<title>Register-login-form Website Template | Home :: w3layouts</title>
		<link href="style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Lobster|Pacifico:400,700,300|Roboto:400,100,100italic,300,300italic,400italic,500italic,500' ' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Raleway:400,100,500,600,700,300' rel='stylesheet' type='text/css'>
		<!--webfonts-->
	</head>
	<body>	
	
		<!--start-login-form-->
				<div class="main">
			    	<div class="login-head">
<div class="Login">
							<div class="Login-head">
						    	<h3>LOGIN</h3>
						 	</div>

						<form action="AdminLogin">
						
						<%
							
							Object obj=session.getAttribute("flag");
							if(obj != null){
							%>
							
							<h3 style="color: red">Invalid username or password</h3>
							
							<%}session.removeAttribute("flag"); %>
						
								<div class="ticker">
									<h4>Username</h4>
						  			<input type="text" placeholder="Enter Email Id" name="email" ><span> </span>
						  			<div class="clear"> </div>
						  		</div>
						  		<div>
						  		<h4>Password</h4>
								<input type="password" placeholder="Enter Password" name="password" >
								  			<div class="clear"> </div>
								</div>
								<div class="checkbox-grid">
									<div class="inline-group green">
									
									<div class="clear"> </div>
									</div>

								</div>
												 
								<div class="submit-button">
									<input type="submit" onclick="myFunction()" value="LOGIN  >" >
								</div>
									<div class="clear"> </div>
								</div>
											
						  </form>
					</div>
			</div>
				
						
			  </div>
			 
			  </body>
			  </html>