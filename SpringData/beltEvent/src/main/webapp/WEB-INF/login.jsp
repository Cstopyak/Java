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
<title>Login</title>
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">Events</a>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/login">Sign-in</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/registration">New User</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
	<%-- <p>
		<c:out value="${error}" />
	</p>
	<form method="post" action="/login">
		<p>
			<label for="email">Email</label> <input type="text" id="email"
				name="email" />
		</p>
		<p>
			<label for="password">Password</label> <input type="password"
				id="password" name="password" />
		</p>
		<input type="submit" value="Login!" />
	</form>
 --%>
	<div class="form">
	<p> Hello, please log-in to access events in your area! </p>
		<p>
			<c:out value="${error}" />
		</p>

		<form:form method="post" action="/login">
			<div class="mb-3">
				<label for="email">Email</label> <input type="text" id="email"
				name="email" class="form-control" />
			</div>
			<div class="mb-3">
				<label for="password">Password</label> <input type="password"
				id="password" name="password" class="form-control" />
			</div>


			<button type="submit" class="btn btn-primary">Register</button>
		</form:form>
	</div>
</body>
</html>