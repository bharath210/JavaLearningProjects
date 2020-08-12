<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<%
		
		response.setHeader("Cache-Control", "no-cahce, no-store, must-revalidate");// for HTTP 1.1
		response.setHeader("Pragma", "no-cahce");// for HTTP 1.0
		response.setHeader("Expires", "0"); // for Proxy

		if(session.getAttribute("usr") == null)
		{
			response.sendRedirect("login.jsp");
		}
	%>
	Welcome ${user} <br>
	<a href="products.jsp">Products</a>
	
	<form action="logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>