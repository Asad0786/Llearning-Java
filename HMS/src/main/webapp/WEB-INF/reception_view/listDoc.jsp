<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common_view/menu.jsp" %>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="com.hms.model.LoginUserData"%>
<%@ include file="/WEB-INF/common_view/menu.jsp" %>
	
<%
if (session == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
}
else
{ if(session.getAttribute("userData")!=null){
	LoginUserData data = new LoginUserData();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%data.getRole();%></title>
</head>
<body>
<table>
	<tr>
	<th>Name </th>
	<th> Email</th>
	<th> Status </th>
	</tr>
	<%
	try {
	ResultSet rs = (ResultSet)request.getAttribute("rs");
	while(rs.next()){

	%>
	<tr>
		<td><%out.print(rs.getString(2)); %></td>
		<td><%out.print(rs.getString(3)); %></td>
		<td><%if(rs.getBoolean(8))
				out.print("Active");
		else
				out.print("Inactive");
			%></td>
		<td><a href="deReg?id=<%=rs.getString(1)%>&st=<%=rs.getBoolean(8)%>">Edit status</a></td>
		</tr>
		<%}
		 }catch(Exception e){
		}
	   }
	} %>
</table>

</body>
</html>