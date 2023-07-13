<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead | create</title>
</head>
<body>
	<div>${EmailError}</div>
	
	<h2>Lead | Create</h2>
	<form action="saveLead" method="post">
		<PRE>
		
				FirstName<input type="text" name="firstName" required/>
				LastName<input type="text" name="lastName" required/>
				LeadSource:<select name="leadSource">
						  <option value="newspaper">Newspaper</option>
						  <option value="radio">Radio</option>
						  <option value="tv">Tv</option>
						  <option value="online">online</option>
						</select>
				Email<input type="email" name="email" required/>
				Mobile<input type="text" name="mobile" max="10" min="10" required/>
				<input type="submit" value="save" />
			</PRE>

	</form>
	
</body>
</html>