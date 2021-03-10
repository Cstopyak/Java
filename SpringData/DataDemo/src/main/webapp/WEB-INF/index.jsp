<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>


	<h3>Create a book</h3>

	<form action="/books/new" method="post">
		<input type="text" name="title" id="" /> <input type="text"
			name="description" id="" /> <input type="text" name="language" id="" />
		<input type="text" name="numOfPages" id="" />
		<button type="submit">Create Book</button>

	</form>

	<%-- ${books} --%>

	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Description</td>
				<td>Languages</td>
				<td>Pages</td>
			</tr>
		</thead>
		<tbody>
			<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
			<c:forEach items= "${books}" var="b">
				<tr>
					<td><c:out value="${b.id }" /></td>
					<td><c:out value="${b.title}" /></td>
					<td><c:out value="${b.description}" /></td>
					<td><c:out value="${b.language}" /></td>
					<td><c:out value="${b.numberOfPages}" /></td>
				<tr>
			</c:forEach>
		</tbody>

	</table>
   
<%-- <h1><c:out value="${book.title}"/></h1>
<p>Description: <c:out value="${book.description}"/></p>
<p>Language: <c:out value="${book.language}"/></p>
<p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
<a href="/books/${book.id}/edit">Edit Book</a>
<%-- <form action="/books/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form> --%>
 --%>
</body>
</html>