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
	<h1>${course.name}</h1>

	<h2>Instructor: ${course.instructor}</h2>
	<h2>Sign ups:</h2>
	
	<br>
	


	<Table class="table table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Sign up Date</th>
				<th>Action
			</tr>
		</thead>

		<tbody>
		
			<c:forEach items="${course.joinusers}" var="user">
				<tr>

					<td>${user.first_name}</td>
					<td>${user.createdAt }</td>

					<c:choose>
					<c:when test="${user.id == user_id}">
					<td> <a href="/courses/${course.id}/cancel"> Remove</a> </td>
					</c:when>
					<c:otherwise>
					<c:choose>
						 <c:when test="${course.joinusers.contains(user)}">

							<td>
							</td>
							
							</c:when>
							 </c:choose>
							</c:otherwise>
							
						
					</c:choose>
					
				</tr>
				
			</c:forEach>
			
		</tbody>
	</Table>
	
	<p><a href="/courses/${course.id}/edit"> Edit here</a></p>
	
	<p><a href="/courses/${course.id}/delete"> Delete</a></p>
</body>
</html>