<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		<c:out value="${books.title}" />
	</h1>
	<p>
		Description:
		<c:out value="${books.description}" />
	</p>
	<p>
		Language:
		<c:out value="${books.language}" />
	</p>
	<p>
		Number of pages:
		<c:out value="${books.numberOfPages}" />
	</p>
	<a href="/books/${books.id}/edit">Edit Book</a>
	<form action="/books/${books.id}" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete">
	</form>
</body>
</html>