<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<body>
	<form action="validate.jsp" method="post">
		<p>
			<label for="uname"><b>Username</b></label> 
			<input type="text" placeholder="Enter Username" name="username" required>
		</p>
		
		<p>
			<label for="psw"><b>Password</b></label> 
			<input type="password" placeholder="Enter Password" name="password" required>
		</p>
		
		<button type="submit">Login</button>
	</form>

<a href="index.jsp">Back</a> 
</body>
</html>