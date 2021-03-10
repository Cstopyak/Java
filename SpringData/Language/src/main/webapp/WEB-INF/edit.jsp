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
<title>Edit Page</title>
</head>
<body>


	<div class="header">
		<a href="/">Dashboard</a> | <a href="/languages/delete/${b.id}">Delete</a>


	</div>
	<div class="middle">
		<p> Name: ${Language.name}</p>
		<p> Creator: ${Language.creator} </p>
		<p> Version ${Language.version}</p>
	
	
	</div>
	
	 <form:form action="/languages/edit/{id}" method="post" modelAttribute="Language">
		<input type="hidden" name="_method" value="put">
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
</body>
</html>