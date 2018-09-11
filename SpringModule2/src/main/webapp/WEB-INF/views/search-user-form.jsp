<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Users</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h3>Search Users</h3>
	<div align="center">
		
			<table cellspacing="10" cellpadding="10">
				<tr>
					<td>
						<form:form method="POST" action="${pageContext.request.contextPath}/user/search-by-id" onsubmit="return isNumber('id')">
						<table>
							<tr>
								<td>By UserID</td>
								<td><input type="text" name="id" id="id" maxlength="7"></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit" value="Search"></td>
							</tr>
						</table>
						</form:form>
					</td>
					<td>
						<form:form method="POST" action="${pageContext.request.contextPath}/user/search-by-name">
						<table>
							<tr>
								<td>By Name</td>
								<td><input type="text" name="name"></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit" value="Search"></td>
							</tr>
						</table>			
						</form:form>
					</td>
					<td>
						<form:form method="POST" action="${pageContext.request.contextPath}/user/search-by-email">
						<table>
							<tr>
								<td>By Email</td>
								<td><input type="text" name="email"></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit" value="Search"></td>
							</tr>
						</table>
						</form:form>
					</td>
				</tr>
			</table>
		
	</div>
</body>
</html>