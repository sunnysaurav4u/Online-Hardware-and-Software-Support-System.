<%@page import="beanPack.EnggBean"%>
<%@page import="com.hw_sw.dao.EnggDaoImpl"%>
<%@page import="com.hw_sw.dao.EnggDao"%>
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
	String enggId=request.getParameter("enggId");
	int id=Integer.parseInt(enggId);
	
	EnggDao dao=new EnggDaoImpl();
	EnggBean ebean=dao.getEnggDetails(id);
	
%>	


<h1 align="center">Engineer Detail</h1>
<hr>

<form action="UpdateEnggSrv" method="post">


Engg Id:<input type="number" name="enggId" value="<%=ebean.getenggId()%>" readonly><br><br>
Engg Name:<input type="text" name="enggName" value="<%=ebean.getenggName()%>" readonly><br><br>
Engg Email:<input type="email" name="enggMail" value="<%=ebean.getenggMail()%>" readonly ><br><br>
Engg Mobile:<input type="number" name="enggMobile" value="<%=ebean.getenggMobile()%>" ><br><br>
Engg Password:<input type="password" name="enggPass" value="<%=ebean.getEnggPassword()%>" ><br><br>


<input type="submit" value="Update">

</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>