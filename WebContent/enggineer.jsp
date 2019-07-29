<%@page import="beanPack.ComplainBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>

<form action="SubmitAnswer">

<table border="1">
	
<tr>
	<th>ComplainId</th>
	<th>ComplainName</th>
	<th colspan="2">ComplainDetails</th>
	<th>ComplainType</th>
	<th colspan="2">ComplainAnswer</th>
</tr>

<%
	Object obj=session.getAttribute("list");
if(obj!=null){
	ArrayList<ComplainBean> list_bean=(ArrayList<ComplainBean>)obj;
%>
<%for(ComplainBean cbean : list_bean){ %>

<tr>
	
	<td name="complId"><%=cbean.getComplainId() %></td>
	<td><%=cbean.getComplainName() %></td>
	<td colspan="2"><textarea rows="2" cols="40" readonly><%=cbean.getComplainDetail() %></textarea></td>
	<td><%=cbean.getComplainType() %></td>
	<td colspan="2"><textarea name="answer" rows="2" cols="60"></textarea></td>
	<td><input type="submit" name="submit"></td>

</tr>
<%} %>
</table>	

</form>
<%}else{ %>
<h2>Session failed...</h2>
<%} %>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>