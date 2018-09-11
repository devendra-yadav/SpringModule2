<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h3>USER REGISTRATION FORM</h3>

	<table align="center">
		<tr>
			<div class="form-output">
				<c:if test="${output.error != null}">
					<td colspan="3" align="center"><div class="error">${output.error}</div></td>
				</c:if>
				<c:if test="${output.success != null}">
					<td colspan="3" align="center"><div class="success">${output.success}</div></td>
				</c:if>
			</div>
		</tr>
	
		<tr>
			<td><br></td>
		</tr>
		<form:form method="POST" action="${pageContext.request.contextPath}/user/create" modelAttribute="user">
			<tr>
				<td>Name</td>
				<td><form:input path="name" /> <form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /> <form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Birthday (dd/mm/yyyy)</td>
				<td><form:input path="birthDay" /> <form:errors path="birthDay" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Register"></td>
			</tr>

		</form:form>
	</table>
</body>
</html>