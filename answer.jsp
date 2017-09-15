<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="engineerHeader.jsp"></jsp:include>

<form  action="SubmitAnswer.jsp?complainId=<%=request.getParameter("complainId") %>" method="get">
	<h1 style="color: red;	">Write Answer</h1>
	<textarea cols="120" rows="15" name="answer"></textarea><br>
	<input type="submit" name="submit" style="color: red;">
</form>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>