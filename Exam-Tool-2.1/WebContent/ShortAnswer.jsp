<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "app.*,org.json.simple.JSONObject,org.json.simple.parser.JSONParser"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Short Answer Question</title>
	<link rel = "stylesheet" type= "text/css" href = "stylesheet.css">
</head>
<body>
<% 	JSONParser j = new JSONParser();
	JSONObject o = (JSONObject)j.parse((String)request.getSession().getAttribute("Question"));
	String question = (String)o.get("question");
%>
	<div class = "question-form">
		<form action = "${pageContext.request.contextPath}/web/storeSA" method = "post" id = "ques">
			<output name = "question" id = "question"><%= question %></output><br><br>
			<textarea rows = "25" cols = "75" name = "answer" id = "answer" form = "ques"></textarea><br><br>
			<input type = "submit" name = "next" id= "next" value = "Next">
		</form>
		
	</div>

</body>
</html>