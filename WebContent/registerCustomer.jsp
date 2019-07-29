<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	

		
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
					    
					</div>
					<div  class="wrap">
						  <div class="Regisration">
						  	<div class="Regisration-head">
						    	<h2><span></span>Register</h2>
						 	 </div>
						 	 
						  	<form action="RegisterCustomer" method="post">
						  		<center>
						  		 
						  		<input type="text" name="name"  value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">
						  		<input type="text" name="email" value="Email Address" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email Address';}" >
						  		<input type="text" name="mobile" value="Mobile" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Mobile';}" >
								<input type="text" name="city" value="City" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'City';}" >
								<input type="password"  name="pass"  placeholder="Enter Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"  >
								<input type="password" placeholder=" Confirm Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = ' Confirm Password';}" >
								 <div class="Remember-me">
								<div class="p-container">
								<!-- <label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>I agree to the Terms and Conditions</label> -->
								<div class ="clear"></div>
								</div>
												 
								<div class="submit" style="align:center">
									<!-- <input type="submit" onclick="myFunction()" value="Sign Me Up > "  > -->
							<input type="submit" value="Sign Me Up"></a>
								</div>
								
								<div>

							<%
							
							Object obj=session.getAttribute("flag");
							if(obj != null){
							%>
							
							<h3 style="color: green">Customer Added. CustomerId : <%=(Integer)session.getAttribute("id") %></h3>
							<div><br>
							<a href="customerLogin.jsp">&nbspLogin Now</a>
								</div>
							<%}session.removeAttribute("flag"); %>
							
							
							</div>
								
									<div class="clear"> </div>
								</div>
									</center>		
						  </form>
					</div>
					
	</body>
</html>


