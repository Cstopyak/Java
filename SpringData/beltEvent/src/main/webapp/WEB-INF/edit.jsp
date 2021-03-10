<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<title>Insert title here</title>
</head>
<body>
<h1> Edit event here</h1>




	<form:form action="/events/${event.id}/edit" method="post" modelAttribute="event">
	<input type="hidden" name="_method" value="put" />
		<form:input path="host" value="${user_id}" type="hidden" />
		<p>
			Name:
			<form:input type="text" path="name" />
			<form:errors path="name" />
		</p>
		<p>
			Event Date:
			<form:input type="date" path="event_date" />
			<form:errors path="event_date" />
		</p>
		<p>
			City:
			<form:input type="text" path="city" />
			<form:errors path="city" />
		</p>
		<p>
			State:
			<form:select path="state">
				<form:option value="il">IL </form:option>
				<form:option value="in">IN </form:option>
				<form:option value="id">ID </form:option>
			</form:select>
		</p>
		<button type="submit">Edit Event</button>
	</form:form>


</body>
</html>