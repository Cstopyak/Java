<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<title>Ninja Gold Game</title>
</head>
<body>
<h1> your Gold: ${gold} </h1>
<a href= "/"> reset</a>


	<div id="wrapper">
		<form class="box" action="/process" method="post">
			<h3>Farm</h3>

			<h3>(earns 10-20 gold)</h3>
			<input type="hidden" value="farm" name= "location">
			<button type="submit" class="btn btn-warning" >Find Gold!</button>
	
		</form>

		<div class="box" action="/process" method="post">
			<h3>Cave</h3>

			<h3>(earns 5-10 gold)</h3>
			<button type="submit" class="btn btn-warning">Find Gold!</button>

		</div>

		<div class="box" action="/process" method="post">
			<h3>House</h3>

			<h3>(earns 2-5 gold)</h3>
			<button type="submit" class="btn btn-warning">Find Gold!</button>

		</div>

		<div class="box" action="/process" method="post">
			<h3>Casino</h3>

			<h3>(earns/takes 0-50 gold)</h3>
			<button type="submit" class="btn btn-warning">Find Gold!</button>

		</div>
		<br>
		<p> Activities: </p>
		
		<div class="Act"></div>
    </div>
	</div>

</body>
</html>