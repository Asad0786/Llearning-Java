<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.hms.model.AppointmentData" %>
<%@ include file="/WEB-INF/common_view/menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Details</title>
</head>
<body>
<%
ArrayList<AppointmentData> data = (ArrayList<AppointmentData>) request.getAttribute("data");

%>
<table border= 1px>
		<tr>
		<th> Pat Name</th>
		<th> Doc Name</th>
		<th> App Date</th>
		</tr>
		<%for(AppointmentData ad: data){ %>
		<tr>
			<td><%= ad.getPatientName() %></td>
			<td><%= ad.getDoctorName()  %></td>
			<td><%= ad.getAppointmentDate()  %></td>
		</tr>
		<% } %>
</table>

</body>
</html>