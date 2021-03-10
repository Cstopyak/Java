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
	<h1>New Ninja</h1>

${dojo.all}
	<form:form action="/ninjas/new" method="post" modelAttribute="ninjaobj">


		<p>
			Select a Dojo:
			<%-- <form:input type="text" path="dojo" required="required" />
			<form:errors path="dojo" /> --%>

			<form:select path="dojo">
				<c:forEach items="${AllDojo}" var="b">
					<form:option value="${b.id}">
						<c:out value="${b.name}" />
					</form:option>
				</c:forEach>
			</form:select>

		</p>

		<p>
			First Name:
			<form:input type="text" path="firstName" required="required" />
			<form:errors path="firstName" />
		</p>

		<p>
			LAst Name:
			<form:input type="text" path="lastName" required="required" />
			<form:errors path="lastName" />
		</p>

		<p>
			Age:
			<form:input type="Number" path="age" required="required" />
			<form:errors path="age" />
		</p>

		<button type="submit">Create</button>
	</form:form>
</body>
</html>