<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 100%;
	border-left: #C8B9AE solid 1px;
	border-top: #C8B9AE solid 1px;
	border-collapse: collapse;
}

table tr, th, td {
	border-right: #C8B9AE solid 1px;
	border-bottom: #C8B9AE solid 1px;
	padding: 10px 10px 6px;
}
</style>
</head>
<body style="font-family: arial, serif;">
	<div align="center" cellpadding=10>

		<table>
			<h2>List of Categories</h2>
			<center>
				<h4>
					<a href="${pageContext.request.contextPath}/categoryServlet?action=new">Add New Category</a>
					<a href="${pageContext.request.contextPath}/bookServlet">Book Manage</a>
				</h4>
			</center>
			<tr align=center>
				<th>ID</th>
				<th>Category</th>
			</tr>
			<c:forEach var="item" items="${list}">
				<tr align=center>
					<td>${item.cid }</td>
					 <td>${item.categoryTitle }</td>
					<td>|<a
						href="${pageContext.request.contextPath}/categoryServlet?action=edit&id=${item.cid}">Edit</a>|
						|<a href="#" onclick="deleteBook(${item.cid})">Delete</a>|
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
function deleteBook(id){
    if(confirm('Are you sure to delete this category?')){
       window.location.href="${pageContext.request.contextPath}/categoryServlet?action=delete&id="+id;
    } 
}
</script>
</html>