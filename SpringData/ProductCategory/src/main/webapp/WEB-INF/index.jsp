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
<h1> Create a Product</h1>

 <form:form action="/product/new" method="post" modelAttribute="product">
		
		<p>
			<form:label path="name"> Name </form:label>
			<form:input type="text" path="name" required="required"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required"/>
		</p>
		<p>
			<form:label path="price">Price</form:label>
			<form:input type="number" path="price" required="required"/> 
		</p>
		<button type="submit">Create</button>
	</form:form>
	
	
	
</body>
</html>