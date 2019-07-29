<%@page import="beanPack.EnggBean"%>
<%@page import="com.hw_sw.dao.EnggDaoImpl"%>
<%@page import="com.hw_sw.dao.EnggDao"%>
<%@page import="beanPack.ComplainBean"%>
<%@page import="java.util.ArrayList"%>
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


<table border="1">

	<tr>
		<th>Complain Id</th>
		<th>Complain Title</th>
		<th>Complain Detail</th>
		<th>Complain Type</th>
		<th>Complain Status</th>
		
		<th>Answer</th>
		<th>Customer Id</th>
		
		<th>Select Engineer</th>
		<th>Assign</th>
	</tr>
	<%
	Object obj1=session.getAttribute("complainList");
	if(obj1 != null){
		ArrayList<ComplainBean> cList=(ArrayList<ComplainBean>)obj1;
		
		EnggDao dao = new EnggDaoImpl();
		ArrayList<EnggBean> enggList = dao.getAllEngineerDetails();
	
   %>
   
	<%
	for(ComplainBean cBean:cList){
		
	%>
	<form action="ProcessComplainSrv?complainId=<%=cBean.getComplainId() %>" method="post">
	<tr>
		<td><%=cBean.getComplainId() %></td>
		<td><%=cBean.getComplainName() %></td>
		<td><%=cBean.getComplainDetail() %></td>
		
		<td><%=cBean.getComplainStatus()%></td>
		<td><%=cBean.getComplainType() %></td>
		<td><%=cBean.getComplainAnswer()%></td>
		<td><%=cBean.getCustomerId()%></td>
		<td><select name="enggMail">
				<% 
				for(EnggBean b:enggList){
					out.print(b.getenggMail());
				%>
				<option value="<%=b.getenggMail() %>" ><%=b.getenggMail() %></option>
				<%} %>
				</select>
		<td><input type="submit"></input></td>
	</tr>
	</form>
	<%} %>

</table>




<%}else {%>
<h2>Session fails..</h2>
 <%} %>
<h2 align="center"><a href="admin.jsp">Go Back</a></h2>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>