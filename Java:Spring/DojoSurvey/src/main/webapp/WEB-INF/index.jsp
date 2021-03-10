<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Dojo!</h1>

	<form action="/survey" method="post">

		<p>
			Your Name: <input type="text" name="name" id="">
		</p>

		<p>
			Dojo Location: <select name="location" id="">
				<option value="Please select from below">Please select from
					below</option>
				<option value="Chicago">Chicago</option>
				<option value="Washington">Washington</option>
				<option value="California">California</option>
			</select>
		</p>

		<p>
			Favorite Language: <select name="Favlanguage" id="">
				<option value="Please select from below">Please select from
					below</option>
				<option value="Python">Python</option>
				<option value="java">Java</option>
				<option value="C#">C#</option>
			</select>
		</p>

		<p>
			Comment (optional):
			<textarea name="comment" id=""></textarea>
		</p>

		<input type="submit" value="Submit">
	</form>
</body>
</html>