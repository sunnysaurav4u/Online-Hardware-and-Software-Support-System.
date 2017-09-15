<%@page import="com.hw_sw.dao.ComplainDaoImpl"%>
<%@page import="com.hw_sw.dao.ComplainDao"%>
<%@page import="beanPack.ComplainBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="engineerHeader.jsp"></jsp:include>



<table border="1">
	
<tr>
	<th>ComplainId</th>
	<th>ComplainName</th>
	<th colspan="2">ComplainDetails</th>
	<th>ComplainType</th>
	<th colspan="2">ComplainAnswer</th>
</tr>

<%
	
		int enggId=(Integer)session.getAttribute("enggId");
		ComplainDao cdao=new ComplainDaoImpl();	
		ArrayList<ComplainBean> list=cdao.getComplainEnggId(enggId);
		if(list != null){
		
%>
<%for(ComplainBean cbean : list){ %>

<tr>
	<form  action="submitAnswer" method="post">
	<td><input type="text" name="complainId" value="<%=cbean.getComplainId() %>" readonly></td>
	<td><%=cbean.getComplainName() %></td>
	<td colspan="2"><textarea rows="2" cols="40" readonly><%=cbean.getComplainDetail() %></textarea></td>
	<td><%=cbean.getComplainType() %></td>
	<td colspan="2"><textarea name="answer" rows="2" cols="30" ><%=cbean.getComplainAnswer() %></textarea></td>
	<td><input type="submit" name="submit"></td>
	</form>
</tr>
<%} %>
</table>	



<%}else{ %>
<h2>Session failed...</h2>
<%} %>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>