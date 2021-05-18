<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Books</title>
</head>
<body>
    <center>
		<h4>
			<a href="${pageContext.request.contextPath}/bookServlet">List All Books</a>
		</h4>
	</center>
	<div align="center">
		<c:if test="${book != null}">
			<form action="${pageContext.request.contextPath}/bookServlet" method="post">
				<input type="hidden" name="action" value="update">
		</c:if>
		<c:if test="${book == null}">
			<form action="${pageContext.request.contextPath}/bookServlet?action=insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${book != null}">
						 Edit Book
						 </c:if>
					<c:if test="${book == null}">
					 Add New Book
					 </c:if>
				</h2>
			</caption>
			<c:if test="${book != null}">
				<input type="hidden" name="bid"
					value="${book.bId }" />
			</c:if>
			<c:if test="${book == null}">
				<tr>
					<th>Book Id:</th>
					<td><input type="text" name="bid" required /></td>
				</tr>
			</c:if>
			<c:if test="${book == null}">
			<tr>
				<th>Category:</th>
				<td> 
					<select name="cid">
						<c:forEach items="${categories}" var="item">
							<option value="<c:out value='${item.cid}' />">${item.categoryTitle }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			</c:if>
			<c:if test="${book != null}">
			<tr>
				<th>Category:</th>
				<td> 
					<select name="cid">
						<c:forEach items="${categories}" var="item">
							<option ${item.cid==book.cId ? 'selected' :'' } value="<c:out value='${item.cid}' />">${item.categoryTitle }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			</c:if>
			<tr>
				<th>Title:</th>
				<td><input type="text" name="title" required
					value="<c:out value='${book.getBookTitle()}' />" /></td>
			</tr>
			<tr>
				<th>Author:</th>
				<td><input type="text" name="author" required
					value="<c:out value='${book.getAuthor()}' />" /></td>
			</tr>
			<tr>
				<th>ISBN:</th>
				<td><input type="text" name="isbn" required
					value="<c:out value='${book.getIsbn()}' />" /></td>
			</tr>
			<tr>
				<th>Price:</th>
				<td><input type="text" name="price" required
					value="<c:out value='${book.getPrice()}' />" /></td>
			</tr>
			<tr>
				<th>NoofPages:</th>
				<td><input type="text" name="noofpages" required
					value="<c:out value='${book.getNoofPages()}' />" /></td>
			</tr>
			<tr>
				<th>Description:</th>

				<td><textarea required rows="3" cols="8" name="description"><c:out
							value='${book.getDescription()}' /></textarea></td>
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