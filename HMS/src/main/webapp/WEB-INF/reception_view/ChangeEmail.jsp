<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common_view/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Email</title>
</head>
<body>
	<form action="editEmail" method="post">
		<input type="email" name="oldEmail"
			value=<%out.print(request.getAttribute("email"));%> hidden=true>
		<br>Current Email:
		<%
		out.print(request.getAttribute("email"));
		%><br> Enter new Email:<input
			type="email" name="newEmail"> <input type="submit"
			value="update!">
	</form>
</body>
</html>