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
<title>Registration</title>
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
          <a class="nav-link active" aria-current="page" href="#">Home</a>
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


	<div class="form">
		<p>
			<form:errors path="user.*" />
		</p>
		

		<form:form method="POST" action="/registration" modelAttribute="user">
			<div class="mb-3">
				<form:label path="first_name">First_name:</form:label>
				<form:input type="text" path="first_name" class="form-control" />
			</div>
			<div class="mb-3">
				<form:label path="first_name">Last_name:</form:label>
				<form:input type="text" path="last_name" class="form-control" />
			</div>

			<div class="mb-3">
				<form:label path="city">City:</form:label>
				<form:input type="text" path="city" class="form-control" />
			</div>

			<div class="mb-3">
				<form:select path="state">State:
	            	<form:option value="Select from below"> Please select </form:option>
					<form:option value="AL">Alabama</form:option>
					<form:option value="AK">Alaska</form:option>
					<form:option value="AZ">Arizona</form:option>
					<form:option value="AR">Arkansas</form:option>
					<form:option value="CA">California</form:option>
					<form:option value="CO">Colorado</form:option>
					<form:option value="CT">Connecticut</form:option>
					<form:option value="DE">Delaware</form:option>
					<form:option value="DC">District Of Columbia</form:option>
					<form:option value="FL">Florida</form:option>
					<form:option value="GA">Georgia</form:option>
					<form:option value="HI">Hawaii</form:option>
					<form:option value="ID">Idaho</form:option>
					<form:option value="IL">Illinois</form:option>
					<form:option value="IN">Indiana</form:option>
					<form:option value="IA">Iowa</form:option>
					<form:option value="KS">Kansas</form:option>
					<form:option value="KY">Kentucky</form:option>
					<form:option value="LA">Louisiana</form:option>
					<form:option value="ME">Maine</form:option>
					<form:option value="MD">Maryland</form:option>
					<form:option value="MA">Massachusetts</form:option>
					<form:option value="MI">Michigan</form:option>
					<form:option value="MN">Minnesota</form:option>
					<form:option value="MS">Mississippi</form:option>
					<form:option value="MO">Missouri</form:option>
					<form:option value="MT">Montana</form:option>
					<form:option value="NE">Nebraska</form:option>
					<form:option value="NV">Nevada</form:option>
					<form:option value="NH">New Hampshire</form:option>
					<form:option value="NJ">New Jersey</form:option>
					<form:option value="NM">New Mexico</form:option>
					<form:option value="NY">New York</form:option>
					<form:option value="NC">North Carolina</form:option>
					<form:option value="ND">North Dakota</form:option>
					<form:option value="OH">Ohio</form:option>
					<form:option value="OK">Oklahoma</form:option>
					<form:option value="OR">Oregon</form:option>
					<form:option value="PA">Pennsylvania</form:option>
					<form:option value="RI">Rhode Island</form:option>
					<form:option value="SC">South Carolina</form:option>
					<form:option value="SD">South Dakota</form:option>
					<form:option value="TN">Tennessee</form:option>
					<form:option value="TX">Texas</form:option>
					<form:option value="UT">Utah</form:option>
					<form:option value="VT">Vermont</form:option>
					<form:option value="VA">Virginia</form:option>
					<form:option value="WA">Washington</form:option>
					<form:option value="WV">West Virginia</form:option>
					<form:option value="WI">Wisconsin</form:option>
					<form:option value="WY">Wyoming</form:option>
				</form:select>
			</div>

			<form:label path="email">Email:</form:label>
			<input type="email" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp">
			<div id="emailHelp" class="form-text">We'll never share your
				email with anyone else.</div>
			<div class="mb-3">
				<form:label path="password">Password:</form:label>
				<form:password path="password" class="form-control" />
			</div>

			<div class="mb-3">
				<form:label path="passwordConfirmation">Password Confirmation:</form:label>
				<form:password path="passwordConfirmation" class="form-control" />
			</div>

			<button type="submit" class="btn btn-primary">Register</button>
		</form:form>
	</div>
</body>
</html>