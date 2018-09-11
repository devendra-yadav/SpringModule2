<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unexpected Exception</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h3>Exception</h3>
	<div align="center" class="global-error">
		Some unexpected exception occurred. ${exception}
	</div>
</body>
</html>