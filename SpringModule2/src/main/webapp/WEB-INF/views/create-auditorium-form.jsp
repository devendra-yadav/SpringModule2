<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Auditorium</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h3>AUDITORIUM CREATION FORM</h3>

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
		<form:form method="POST" action="${pageContext.request.contextPath}/auditorium/create" modelAttribute="auditorium" onsubmit="return isNumber('seatsNumber')">
			<tr>
				<td>Name</td>
				<td><form:input path="name" /> <form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Sitting Capacity</td>
				<td><form:input path="seatsNumber" id="seatsNumber" /> <form:errors path="seatsNumber" cssClass="error"/></td>
			</tr>
			<tr>
				<td>VIP Seats (comma separated)</td>
				<td><form:input path="vipSeats" /> <form:errors path="vipSeats" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Create"></td>
			</tr>

		</form:form>
	</table>
</body>
</html>