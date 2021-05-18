<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
</head>
<body>
<div align="center" cellpadding="10">

		<table>
			<h2>List of Categories</h2>
			<center>
				<h4>
					<a href="${pageContext.request.contextPath}/AdminBookCategoryServlet?action=new">Add New Category</a>
					<a href="${pageContext.request.contextPath}/AdminBookListServlet">Book List</a>
				</h4>
			</center>
			<tr align=center>
				<th>ID</th>
				<th>Category</th>
			</tr>
			<c:forEach var="category" items="${listBookCategory}">
				<tr align=center>
					<td>${category.cid}</td>
					 <td>${category.categoryTitle}</td>
					<td>|<a
						href="${pageContext.request.contextPath}/AdminBookCategoryServlet?action=edit&id=${category.cid}">Edit</a>|
						|<a href="#" onclick="deleteBook(${category.cid})">Delete</a>|
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
function deleteBook(id){
    if(confirm('Are you sure to delete this category?')){
       window.location.href="${pageContext.request.contextPath}/AdminBookCategoryServlet?action=delete&id="+id;
    } 
}
</script>
</html>