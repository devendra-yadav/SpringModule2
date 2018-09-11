<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Matched User</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>Matched User</h3>
	<div align="center">
		<c:choose>
			<c:when test="${user !=null}">
				<table>
					<tr>
						<td>User ID</td>
						<td>${user.id}</td>
					</tr>
					<tr>
						<td>Name</td>
						<td>${user.name}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td>${user.email}</td>
					</tr>
					<tr>
						<td>BirthDay</td>
						<td>${user.birthDay}</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				No used found
				<br>
			</c:otherwise>
		</c:choose>
		<br>
		<a href="${pageContext.request.contextPath}/user/search-form""><input type="button" value="Search Another User"></a>
	</div>
</body>
</html>