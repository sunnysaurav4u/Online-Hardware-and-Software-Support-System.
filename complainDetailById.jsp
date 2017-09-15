<%@page import="beanPack.ComplainBean"%>
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

<form action="SrvComplainDetailByid">
	Enter the Complain Id:<input type="text" name="complainId"><br><br>
	<input type="submit" value="Submit">

</form>

<%
						Object temp = session.getAttribute("temp");
						if(temp!=null){	
							
							Object obj=session.getAttribute("complainBeanObj");
							if(obj != null){
							ComplainBean cbBean=(ComplainBean)obj;
							
						
%>



<div  align="center" style="margin-top: 80px;" >
	<table border="1">
	<tr align="center">
		 Complain details are:
	</tr>
	<tr>
		
		<th>ComplainName</th>
		<th>ComplainDetail</th>
		<th>ComplainStatus</th>
		<th>ComplainType</th>
		<th>ComplainAnswer</th>
		<th>CustomerId</th>
	
	</tr>

	<tr>

		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= cbBean.getComplainName() %></textarea></td>
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= cbBean.getComplainDetail()%></textarea></td>
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= cbBean.getComplainType()%></textarea></td>
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= cbBean.getComplainStatus() %></textarea></td>
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= cbBean.getComplainAnswer() %></textarea></td>
		<td><textarea name="txt_descripcion" cols="15" rows="3" id="txt_descripcion"><%= cbBean.getCustomerId()%></textarea></td>
		

	</tr>

</table>
</div>
<%}else { %>

<h2>Session fails....</h2>

<%}
			session.removeAttribute("temp");
}
%>
<h2 align="center"><a href="admin.jsp">Go Back</a></h2>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>