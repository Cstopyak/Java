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



	<form:form action="/books/new" method="post" modelAttribute="book">
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input type="text" path="title" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</p>
		<p>
			<form:label path="language">Language</form:label>
			<form:errors path="language" />
			<form:input path="language" />
		</p>
		<p>
			<form:label path="numberOfPages">Pages</form:label>
			<form:errors path="numberOfPages" />
			<form:input type="number" path="numberOfPages" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>

	<br>

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

			<c:forEach items="${books}" var="b">
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
</body>
</html>