<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel = "stylesheet" type= "text/css" href = "css/stylesheet.css">
</head>
<body>
<h1>Student Login</h1>
	<div class = "form-container">
		<form action = "${pageContext.request.contextPath}/web/add" method = "post">
			<input type = "text" id = "studentName" name = "studentName" placeholder = "Student Name"><br>
			<input type = "text" id = "idNum" name = "idNum" placeholder = "ID Number"><br>
			<input type = "text" id = "recNum" name = "recNum" placeholder = "Recitation Number"><br>
			<input type = "text" id = "netid" name = "netid" placeholder = "NetID"><br>
			<input type = "password" id = "password" name = "password" placeholder = "Password"><br><br>
			<input type = "submit" id = "takeTest" name = "takeTest" value = "Take Test">
		</form>
	</div>

</body>
</html>