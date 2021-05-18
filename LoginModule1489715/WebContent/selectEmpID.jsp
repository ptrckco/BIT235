<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Enter Employee ID to verify whether Employee exists
or not</p>
<form action="Verify.jsp" method="get">
<p>
<label for="empid"><b>Employee ID: </b></label>
<input type="text" placeholder="Enter Employee ID like
101" name="empid" required>
</p>
<button type="submit">Verify</button>
</form>
</body>
</html>