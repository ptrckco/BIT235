<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="LoginServlet" method="get">
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


</body>
</html>