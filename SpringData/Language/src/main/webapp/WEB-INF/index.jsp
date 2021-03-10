<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<title>Dashboard</title>
</head>
<body>


	<h1>Hello</h1>

 <h3>Create a book</h3>
	 <form:form action="/languages/new" method="post" modelAttribute="language">
		
		<p>
			<form:label path="name"> Name </form:label>
			<form:input type="text" path="name" required="required"/>
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:input type="text" path="creator" required="required"/>
		</p>
		<p>
			<form:label path="version">Version</form:label>
			<form:input type="number" path="version" required="required"/> 
		</p>
		<button type="submit">Submit</button>
	</form:form>

	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Description</td>
				<td>Languages</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${languages}" var="b">
				<tr>
					<td><c:out value="${b.id }" /></td>
					<td> <a href="/languages/show/${b.id}">  <c:out value="${b.name}" /> </a></td>
					<td><c:out value="${b.creator}" /></td>
					<td><c:out value="${b.version}" /></td>
					<td><a href="/languages/edit/${b.id}"> Edit</a> | <a href="/languages/delete/${b.id}"> Delete</a></td>
				<tr>
			</c:forEach>
		</tbody>

	</table>

	


</body>
</html>