<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Submitted info!</h1>
	
	
	
	<p>First Name: ${name}</p>
	<p>Dojo Location: ${location}</p>
	<p>Favorite Language: ${Favlanguage}</p>
	<p>Comment: ${comment}</p>

	<a href="../"><input type="button" value="Back"
		class="btn btn-primary" /></a>

	<%-- <p>First Name: <c:out value="${name}"/></p>
	<p>Dojo Location: <c:out value="${location}"/></p>
	<p>Favorite Language: <c:out value="${Favlanguage}"/></p>
	<p>Comment: <c:out value="${comment}"/></p>

	<a href="../"><input type="button" value="Back"
		class="btn btn-primary" /></a> --%>


</body>
</html>