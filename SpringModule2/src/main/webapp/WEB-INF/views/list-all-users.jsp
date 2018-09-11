<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<meta charset="ISO-8859-1">
<title>All Users</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>All Users</h3>
	<a href="${pageContext.request.contextPath}/user/pdf/list-all"><input type="button" value="Download as PDF"></a>
	<div align="center">
		
		<c:choose>
			<c:when test="${fn:length(allUsers) != 0}">
				<table cellspacing="10" cellpadding="10">
					<tr>
						<th>User ID</th>
						<th>Name</th>
						<th>Email ID</th>
						<th>Birthday</th>
					</tr>
					
					<c:forEach items="${allUsers}" var="user">
					<tr>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.name}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
						<td><c:out value="${user.birthDay}"></c:out></td>
					</tr>
					</c:forEach>	
				</table>		
			</c:when>
			<c:otherwise>
				No users found.
			</c:otherwise>
		</c:choose>
		
	</div>
</body>
</html>