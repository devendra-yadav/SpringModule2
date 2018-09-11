<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<meta charset="ISO-8859-1">
<title>All Auditoriums</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>All Auditoriums</h3>
	<a href="${pageContext.request.contextPath}/auditorium/pdf/list-all"><input type="button" value="Download as PDF"></a>
	<div align="center">
		
		<c:choose>
			<c:when test="${fn:length(allAuditoriums) != 0}">
				<table cellspacing="10" cellpadding="10">
					<tr>
						<th>Auditorium ID</th>
						<th>Name</th>
						<th>Sitting Capacity</th>
						<th>VIP Seats</th>
					</tr>
					
					<c:forEach items="${allAuditoriums}" var="auditorium">
					<tr>
						<td align="center"><c:out value="${auditorium.id}"></c:out></td>
						<td align="center"><c:out value="${auditorium.name}"></c:out></td>
						<td align="center"><c:out value="${auditorium.seatsNumber}"></c:out></td>
						<td align="center"><c:out value="${auditorium.vipSeats}"></c:out></td>
					</tr>
					</c:forEach>	
				</table>		
			</c:when>
			<c:otherwise>
				No Auditoriums found.
			</c:otherwise>
		</c:choose>
		
	</div>
</body>
</html>