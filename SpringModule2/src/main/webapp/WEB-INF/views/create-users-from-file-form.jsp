<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload File To Create Users</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h3>Upload File To Create Users</h3>
	<div align="center">
		<c:if test="${output.success != null}">
			<div class="success">
				${output.success}
			</div>
		</c:if>
	</div>
	<table align="center" cellspacing="10" cellpadding="10">
		<tr>
			<form:form action="${pageContext.request.contextPath}/user/create-users-from-file" method="post" enctype="multipart/form-data">
			<td>File (JSON Format)</td>
			<td>
				<input type="file" name="name">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="Submit" value="Upload">
			</td>
			</form:form>
		</tr>
	</table>
		
</body>
</html>