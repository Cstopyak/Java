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
<h1> Hello</h1>

<h2>Event: ${event.name }</h2>
<h2> Created by: ${event.host.first_name } ${event.host.last_name } </h2>
<h2> Location: ${event.city } ${event.state }</h2>
<h2> When: ${event.event_date }</h2>
<p> ${joinusers} </p>
<Table class="table table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Location</th>
				</tr>
				</thead>
				
				<tbody>
				 <c:forEach items="${event.joinusers}" var="user">
				<tr>
					
					 <td>${user.first_name}</td> 
					<td>${user.city},${user.state}</td>
					</tr>
					</c:forEach> 
				</tbody>
				</Table>
</body>
</html>