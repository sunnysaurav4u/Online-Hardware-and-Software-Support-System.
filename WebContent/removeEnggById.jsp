 errorPage="error.jsp"<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<form action="RemoveEngg">

Enter The Id Of Enggineer:<input type="text" name="engId" placeholder="Enter the engg. id"><br><br>
<input type="submit" value="submit">

</form>
<%

Object temp = session.getAttribute("temp");
if(temp!=null){	
	Object obj=session.getAttribute("boolValue");
	if(obj != null){
	boolean bool=(boolean)obj;
	if(bool = true){
%>

<h2>Engineer Removed Successfully</h2>


<%}else{ %>
<h2>Engineer deletion failed...</h2>


<%}}else{ %>
<h2>Session fails</h2>
<%}
	session.removeAttribute("temp");
}
%>
<%session.removeAttribute("flag"); %>
<h2 align="center"><a href="admin.jsp">Go Back</a></h2>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>