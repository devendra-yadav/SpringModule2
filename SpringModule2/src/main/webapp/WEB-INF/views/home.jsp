<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Theater Management Home</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div align="center">
		<table border="0" cellspacing="10" cellpadding="10">
			<tr>
				<th>USER</th>
				<th>AUDITORIUM</th>
				<th></th>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/user/create-form">Create User</a></td>
				<td><a href="${pageContext.request.contextPath}/auditorium/create-form">Create Auditorium</a></td>
				<td/>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/user/list-all">List All Users</a></td>
				<td><a href="${pageContext.request.contextPath}/auditorium/list-all">List All Auditoriums</a></td>
				<td/>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/user/search-form">Search Users</a></td>
				<td/>
				<td/>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/user/create-users-from-file-form">Create Users from file</a></td>
				<td/>
				<td/>
			</tr>
		</table>
	</div>
</body>
</html>