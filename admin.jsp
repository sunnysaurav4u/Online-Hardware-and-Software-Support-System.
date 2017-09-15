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
<jsp:include page="adminHeader.jsp"></jsp:include>

	<div style="color: red" > <h1 align="center">Welcome Admin<h1></div>
	<hr>
	<div>
		<h2 align="center"> Select the Options...</h2><hr>
<table align="center">

			<tr><td><a href="addEngg.jsp" style="text-decoration: none;">Add Engineers</a><br><br></td></tr>
			<tr><td><a href="viewEnggById.jsp" style="text-decoration: none;">View Engineers By ID</a><br><br></td></tr>
			<tr><td><a href="AllEngSrv" style="text-decoration: none;">View All Engineers</a><br><br></td></tr>
			<tr><td><a href="complainDetailById.jsp" style="text-decoration: none;">View Complain By Id</a><br><br></td></tr>
			<tr><td><a href="AssignComplain" style="text-decoration: none;">Assign Complain to Engineer</a><br><br></td></tr>
			<tr><td><a href="complainStatusById.jsp" style="text-decoration: none;">View Complain Status By Id</a><br><br></td></tr>
			<tr><td><a href="removeEnggById.jsp" style="text-decoration: none;">Remove Engineer</a><br><br></td></tr>
			
</table>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
 
 
 
</body>
</html>