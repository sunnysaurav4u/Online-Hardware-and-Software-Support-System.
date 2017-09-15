<%@page import="beanPack.EnggBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hw_sw.dao.EnggDao" %>
<%@page import="com.hw_sw.dao.EnggDaoImpl" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="adminHeader.jsp"></jsp:include>

<%

EnggDao dao=new EnggDaoImpl();

ArrayList<EnggBean> elist=dao.getAllEngineerDetails();

//request.getSession().setAttribute("eng_list", elist);






//Object obj=session.getAttribute("eng_list"); 
//if(obj != null){
	if(true){
	//ArrayList<EnggBean> elist1=(ArrayList<EnggBean>)obj;
%>
<table  border="2px">
<tr>
<th>Id</th><th>Name</th><th>Username(Email)</th><th>Password</th><th>Mobile</th>
</tr>
<%
for(EnggBean ebean:elist){
	%>
							<tr><td>
							<%= ebean.getenggId()%>
						</td><td>
							<%= ebean.getenggName() %>
							</td><td>
							<%= ebean.getenggMail() %>
							</td><td>
							<%= ebean.getEnggPassword() %>
							</td><td>
							<%= ebean.getenggMobile() %>
								</td><td>
							<a href='updateInfo.jsp?enggId=<%=ebean.getenggId()%>'>update</a></td></tr>
							<%} %>

							</table>
							


<%}else{ %>

<h2>Session fails...</h2>

<%} %>
<h2 align="center"><a href="admin.jsp">Go Back</a></h2>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>