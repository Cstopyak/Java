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
	<h1>Hello ${user.first_name}</h1>

<p><a href="/logout"> Logout</a></p>


	<Table class="table table-dark">
		<thead>
			<tr>
				<th>Course</th>
				<th>Instructor</th>
				<th>Signups</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${courses}" var="course">
				<tr>
					<td><a href="/courses/${course.id}"> ${course.name} </a></td>
					<td>${course.instructor}</td>
					<td><c:set var="count" value="0" /> <c:forEach
							items=" ${course.joinusers}" var="user">
							<c:set var="count" value="${count+1}" />
						</c:forEach> 
						<c:out value="${count}/${course.capacity}" />
						</td>



					<c:choose>
						<c:when test="${course.joinusers.contains(user)}">

							<td><a href="/courses/${course.id}/join"> Join</a></td>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${course.joinusers.contains(user)}">
									<td><a href="/courses/${course.id}/cancel"> Cancel</a>
								</c:when>
								<c:otherwise>
									<td><a href="/courses/${course.id}/join"> Join</a></td>
								</c:otherwise>
							</c:choose>
						</c:otherwise>

					</c:choose>

				</tr>
			</c:forEach>
		</tbody>

	</Table>



	<p>
		<a href="courses/new">Add a course</a>
	</p>
</body>
</html>