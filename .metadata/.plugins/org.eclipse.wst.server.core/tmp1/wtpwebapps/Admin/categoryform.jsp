<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>categorys</title>
</head>
<body>
	<center>
		<h4>
			<a href="${pageContext.request.contextPath}/categoryServlet">List All Categories</a>
		</h4>
	</center>
	<div align="center">
		<c:if test="${category != null}">
			<form action="${pageContext.request.contextPath}/categoryServlet" method="post">
				<input type="hidden" name="action" value="update">
		</c:if>
		<c:if test="${category == null}">
			<form action="${pageContext.request.contextPath}/categoryServlet?action=insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${category != null}">
						 Edit category
						 </c:if>
					<c:if test="${category == null}">
					 Add New category
					 </c:if>
				</h2>
			</caption>
			<c:if test="${category != null}">
				<input type="hidden" name="cid"
					value="${category.cid }" />
			</c:if>
			<c:if test="${category == null}">
				<tr>
					<th>category Id:</th>
					<td><input type="text" name="cid" required /></td>
				</tr>
			</c:if>
	 
			<tr>
				<th>Title:</th>
				<td><input type="text" name="categorytitle" required
					value="${category.categoryTitle}" /></td>
			</tr>
			 
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>