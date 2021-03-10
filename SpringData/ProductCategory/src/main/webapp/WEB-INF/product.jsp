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

	<div class="container">
		<h1>
			information on
			<c:out value="${prodObj.name }" />
		</h1>

		<form:form action="/category/new" method="post" modelAttribute="productcategory">
			<form:input type="hidden" path="product" value="${prodObj.id}" />
				<form:select path="category">
					<c:forEach items="${allCategory}" var="category">
					
						<form:option value="${category.id }">
							<c:out value= "${category.name}" />

						</form:option>

					</c:forEach>
				</form:select>

			<button type="submit">Add</button>
		</form:form>
		
		<h2> Categories</h2>
		<c:forEach items="${allCategory}" var="category">
			<li>
				
				<c:out value= "${category.name}" />
			</li>
		
		
		</c:forEach>

	</div>

</body>
</html>