<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>compose Email</title>
</head>
<body>
	<form action="sendEmail" method="post">
		<h2>
			<pre>
			To<input type="text" name="to" value="${email}" />
			Sub<input type="text" name="sub" />
			Text<textarea name="body" rows="30" cols="70">
				</textarea>
			<input type="submit" value="send email"/>
		</pre>
		</h2>
	</form>
	${msg}

</body>
</html>