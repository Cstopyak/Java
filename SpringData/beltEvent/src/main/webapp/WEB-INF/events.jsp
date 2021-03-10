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
	<div class="header">
		<h4>Welcome ${user.first_name},</h4>
	</div>
<nav class="navbar bg-primary">
	<ul>
		<li><a href="">List of events</a></li>

		<li><a href="/SettingsPage">Create an event</a></li>
		<li style="float: right"><a class="active" href="/logout">
				Logout here</a></li>
	</ul>
</nav>
	<p>Here are some events in your state.</p>


	<Table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${myevents}" var="myevent">
				<tr>
					<td><a href="/events/${myevent.id}"> ${myevent.name} </a></td>
					<td>${myevent.event_date}</td>
					<td>${myevent.city},${myevent.state}</td>
					<td>${myevent.host.first_name}</td>

					<c:choose>
						<c:when test="${myevent.host.id == user_id}">
							<td><a href="/events/${myevent.id}/edit"> Edit</a> <a
								href="/events/${myevent.id}/delete"> Delete</a></td>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${myevent.joinusers.contains(user)}">
									<td><a href="/events/${myevent.id}/cancel"> Cancel</a>
								</c:when>
								<c:otherwise>
									<td><a href="/events/${myevent.id}/join"> Join</a></td>
								</c:otherwise>
							</c:choose>
						</c:otherwise>

					</c:choose>
					<%-- <c:if test="${event.host.id != user_id}">
						<td>Joining <a href="/events/${event.id}/join"> Cancel</a>
						</td>


					</c:if> --%>
				</tr>
			</c:forEach>
			<!--  -->
		</tbody>

	</Table>

	<P>Here are some events not in your state</P>
	<Table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${notmyevents}" var="notevent">
				<tr>
					<td><a href="/events/${notevent.id}"> ${notevent.name} </a></td>

					<td>${notevent.event_date}</td>
					<td>${notevent.city},${notevent.state}</td>
					<td>${notevent.host.first_name}</td>

					<c:choose>
						<c:when test="${event.host.id == user_id}">
							<td><a href="/events/${event.id}/edit"> Edit</a> <a
								href="/events/${event.id}/delete"> Delete</a></td>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${event.joinusers.contains(user)}">
									<td><a href="/events/${event.id}/cancel"> Cancel</a>
								</c:when>
								<c:otherwise>
									<td><a href="/events/${event.id}/join"> Join</a></td>
								</c:otherwise>
							</c:choose>
						</c:otherwise>

					</c:choose>
				</tr>


			</c:forEach>
		</tbody>

	</Table>



	<br>
	<h1>Need to create an event?</h1>

	<form:form action="/events/new" method="post" modelAttribute="event">
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
		<button type="submit">Create Event</button>
	</form:form>


<div class="footer">

</div>


</body>
</html>