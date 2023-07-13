<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="menu.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Leads</title>
</head>
<body>
		<a href="startLead">Create New Lead</a>
		
		<h2>Lead Results</h2>
		
		<table border='1'>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Lead Source</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Delete</th>
			</tr>
			
			<c:forEach items ="${leads}" var="lead">
				<tr>
					<td><a href="leadInfo?id=${lead.id}">${lead.firstName}</a></td>
					<td>${lead.lastName}</td>
					<td>${lead.leadSource}</td>
					<td>${lead.email}</td>
					<td>${lead.mobile}</td>
					<td><a href="delete?id=${lead.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		${deleted}
</body>
	
</html>