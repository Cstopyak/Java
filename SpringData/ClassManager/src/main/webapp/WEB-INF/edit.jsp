<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<title>Insert title here</title>
</head>
<body>
<h1> Edit page here</h1>

 <form:form action="/courses/${course.id}/edit" method="post" modelAttribute="course">
 		<input type="hidden" name="_method" value="put" />
		<form:input path="host" value="${user_id}" type="hidden" />
		
		<p>
			Name:
			<form:input type="text" path="name" />
			<form:errors path="name" />
		</p>
		<p>
			Instructor:
			<form:input type="text" path="instructor" />
			<form:errors path="instructor" />
		</p>
		<p>
			Capacity:
			<form:input type="number" path="capacity" />
			<form:errors path="capacity" />
		</p>
		
		<button type="submit">Edit</button>
	</form:form>
</body>
</html>