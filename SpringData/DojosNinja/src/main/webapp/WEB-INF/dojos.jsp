<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<h1> ${dojo.name} Location Ninjas</h1>
<%-- <h1>  ${dojo.Ninja}</h1> --%>

<table>
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
				
			</tr>
		</thead>
		<tbody>

			 <c:forEach items="${dojo.ninjas}" var="b">
				<tr>
					<td><c:out value="${b.firstName }" /></td>
					<td><c:out value="${b.lastName}" /></td>
					<td><c:out value="${b.age}" /></td>
					
				<tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>