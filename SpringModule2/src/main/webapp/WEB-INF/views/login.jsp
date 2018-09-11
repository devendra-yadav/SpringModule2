<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Movie Theater Management - Login</title>
</head>
<body>
	<h1 align="center">Movie Theater Management</h1>
	<h3 align="center">Login</h3>
	<div align="center">
		<c:if test="${param.error != null}">
			<i>Invalid username or password!!!</i>
		</c:if>
	</div>
	<div align="center">
		<table>
			<form:form action="${pageContext.request.contextPath}/processLogin" method="POST">
			<tr>
				<td>Username</td>
				<td>
					<input type="text" name="username">
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login"></td>
			</tr>
			</form:form>
			
		</table>
	</div>


</body>
</html>