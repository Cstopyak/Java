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
<title>Insert title here</title>
</head>
<body>



	<div class="middle">
		<p>Name: ${Language.name}</p>
		<p>Creator: ${Language.creator}</p>
		<p>Version ${Language.version}</p>


	</div>


	<div class="header">
		<a href="/">Dashboard</a> | <a href="/languages/delete/${b.id}">Delete</a>
	<input type="hidden" name="_method" value="delete">
	</div>
</body>
</html>