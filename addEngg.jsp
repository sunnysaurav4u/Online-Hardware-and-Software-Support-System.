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
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>


			    	<h1 align="center">Add Engineers</h1>
					
						 	 
						  	<form action="AddEngg" method="post">
						  		<center>
						  		 
						  		<input type="text" name="name" placeholder="Enter name" >
						  		<input type="text" name="email"  placeholder="Enter Email">
						  		<input type="text" name="mobile" placeholder="Mobile">
								
								<input type="password"  name="pass"  placeholder="Enter Password" >
								<input type="password" placeholder=" Confirm Password"  >
								
									 
								<div class="submit" style="align:center">
									
							<center><input type="submit" value="REGISTER"></center>
							<h2><a href="admin.jsp">Go Back</a></h2>
								</div>
								</center>
								<%
							
							Object obj=session.getAttribute("enggid");
							if(obj != null){
						
							int id=(Integer)obj;%>
							
							<h3 style="color: red">Engineer Added and id is: <%= id %></h3>
							
							<%}session.removeAttribute("enggid"); %>

						  </form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>