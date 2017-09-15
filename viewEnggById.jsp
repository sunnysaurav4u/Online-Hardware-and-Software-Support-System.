<%@page import="beanPack.EnggBean"%>
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

<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>
<form action="GetEnggDetailById">
	Enter the id of Engineer:<input type="text" name="enggid"><br><br>
	<input type="submit" value="Submit">

</form>

<%
							
							Object obj=session.getAttribute("enggBeanObj");
							Object temp = session.getAttribute("temp");
						
				if(temp!=null){				
							
							if(obj==null){
								

%>

							<h2>Session fails....</h2>

<%}
							else{
								
							EnggBean ebean = (EnggBean)obj;
							
						
%>



<div  align="center" style="margin-top: 80px;" >
	<table border="1">
	<tr align="center">
		 Engineers details are:
	</tr>
	<tr>
		<!-- <th>EngineerId</th> -->
		<th>EngineerName</th>
		<th>EngineerEmail</th>
		<th>EngineerPassword</th>
		<th>EngineerMobile</th>
	
	</tr>

	<tr>

		<!-- <td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"></textarea></td> -->
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= ebean.getenggName() %></textarea></td>
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= ebean.getenggMail()%></textarea></td>
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= ebean.getenggMobile() %></textarea></td>
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= ebean.getEnggPassword() %></textarea></td>
		

	</tr>

</table>
	
</div>
		
<%}
							session.removeAttribute("temp");
}
%>
<h2 align="center"><a href="admin.jsp">Go Back</a></h2>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>