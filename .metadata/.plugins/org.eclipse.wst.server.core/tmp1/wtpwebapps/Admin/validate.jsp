<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate User</title>
</head>

<body>
  <%//JDBC driver name and database url  //Step2: Register JDBC driver%>
  <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/bookstore" 
		user="root" password="mysql" />


	<% //Getting Request parameters %> 
    <c:set var = "username" scope = "session" value="${param.username}"/>
    <c:set var = "password" scope = "session" value="${param.password}"/>
	
    
    <%//Step3 Open a connection //Step4 Execute a query %>
	<sql:query dataSource="${snapshot}" var="result">
	 select * from users
		 where username = ?
 	   <sql:param value="${username}" />
	</sql:query>
	
	<c:if test="${result.rowCount <= 0}">
		<c:out value="The username isn't exist" />
	</c:if>
	
	<c:if test="${result.rowCount > 0}">
		<c:forEach var="row" items="${result.rows}">
			<c:choose>
				<c:when test="${row.pass == password}">
					<c:out value="Login success. Welcome!" />
				</c:when>
				
				<c:otherwise>
					<c:out value="Password is incorrect." />
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:if>
	
<br> 
<br>
<a href="login.jsp">Back</a> 

</body>
</html>