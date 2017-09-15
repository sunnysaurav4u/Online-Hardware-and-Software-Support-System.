<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page="customerHeader.jsp"></jsp:include>
<div align="center" style="margin-top: 80px;">
<form action="RegisterComplaint" method="post">
<%-- <input type="hidden" name="Id" value="<%=(Integer)session.getAttribute("customerId")%>"> --%>
<table border="1" >
		<tr>
			<th colspan="2">Register Complain</th>
			<th><a href="CustomerComplainDetails" style="text-decoration: none;">Check Complain Status</a></th>
		</tr>
		<tr>
			<td ><input type="text" name="complainName" placeholder="COMPLAIN NAME   eg.Mother board issue,system crash on power up..." size="85"></td>
			<td>
					<select name="complainType">
							 <option value="null">Select Complain Type</option>
  							 <option value="hardware">Hardware</option>
  							 <option value="software">Software</option>
					</select>
			</td>
			
		</tr>
		<tr >
			<td colspan="2"><textarea cols="100" rows="10" wrap="hard" name="complain"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="submit"></td>
		</tr>

</table>

						<div>

							<%
							
							Object obj=session.getAttribute("flag");
							if(obj != null){
							%>
							
							<h3 style="color: green">Complain Added. Complain Id : <%=(Integer)session.getAttribute("id") %></h3>
							<%}session.removeAttribute("flag"); %>
							
							
							</div>
	
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>