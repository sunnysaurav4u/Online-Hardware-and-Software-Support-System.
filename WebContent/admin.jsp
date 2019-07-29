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
<jsp:include page="adminHeader.jsp"></jsp:include>

	<%-- <div style="color: red" > <h1 align="center">Welcome Admin<h1></div><br><br>--%>
	<hr>
	<div>
		<br><br>
<table align="center">

			<tr><td align="center"><a href="addEngg.jsp"  style="text-decoration: none;"><b>Add Engineers</b></a><br><br></td></tr>
			<tr><td align="center"><a href="viewEnggById.jsp"  style="text-decoration: none;"><b>View Engineers By ID</b></a><br><br></td></tr>
			<tr><td align="center"><a href="AllEngSrv"   style="text-decoration: none;"><b>View All Engineers</b></a><br><br></td></tr>
			<tr><td align="center"><a href="complainDetailById.jsp"  style="text-decoration: none;"><b>View Complain By Id</b></a><br><br></td></tr>
			<tr><td align="center"><a href="AssignComplain"  style="text-decoration: none;"><b>Assign Complain to Engineer</b></a><br><br></td></tr>
			<tr><td align="center"><a href="complainStatusById.jsp"   style="text-decoration: none;"><b>View Complain Status By Id</b></a><br><br></td></tr>
			<tr><td align="center"><a href="removeEnggById.jsp"   style="text-decoration: none;"><b>Remove Engineer</b></a><br><br></td></tr>
			
</table>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
 
 
 
</body>
</html>