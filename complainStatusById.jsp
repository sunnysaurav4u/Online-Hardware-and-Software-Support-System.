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
<title>Insert title here</title>
</head>
<body>

<jsp:include page="adminHeader.jsp"></jsp:include>
<br><br><br><br>
<form action="ComplainStatusById">

<center>Enter ComplainId:<input type="text" name="complainId">
<input type="submit" value="submit"></center>
<%
Object temp = session.getAttribute("temp");
if(temp!=null){	
	Object obj= session.getAttribute("Complainstatus") ;
	if(obj != null){
	String status=(String)obj;
%>
<br><br>
<center>ComplainStatus:<textarea rows="1" cols="20"><%out.print(status); %></textarea></center>

</form>
<%}else{ %>
<a1>SESSION FAILS..</a1><br><br><br><br>
<%}
	session.removeAttribute("temp");
	}
	%>
<h2 align="center"><a href="admin.jsp">Go Back</a></h2>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>