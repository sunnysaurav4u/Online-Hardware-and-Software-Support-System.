<%@page import="java.util.ArrayList"%>
<%@page import="beanPack.ComplainBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<jsp:include page="customerHeader.jsp"></jsp:include>
<table border="1">
	<tr>
		<th>ComplainId</th>
		<th>ComplainName</th>
		<th>ComplainDetail</th>
		<th>ComplainType</th>
		<th>ComplainStatus</th>
		<th>ComplainAnswer</th>
		<th>CustomerId</th>
	</tr>
	<%
		Object obj=session.getAttribute("complainList");
		if(obj != null){
			ArrayList<ComplainBean> cList=(ArrayList<ComplainBean>)obj;
	%>
	<%
	for(ComplainBean cBean:cList){
	%>
	
	<tr>
		<td><%=cBean.getComplainId() %></td>
		<td><%=cBean.getComplainName() %></td>
		<td><%=cBean.getComplainDetail() %></td>
		<td><%=cBean.getComplainType() %></td>
		<td><%=cBean.getComplainStatus()%></td>
		<td><%=cBean.getComplainAnswer()%></td>
		<td><%=cBean.getCustomerId()%></td>
	</tr>
	
	<%} %>
	
</table>
<%}else {%>
<h2>Session fails..</h2>
 <%} %>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>