<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "app.*,org.json.simple.JSONArray,org.json.simple.JSONObject,org.json.simple.parser.JSONParser"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MCQuestion</title>
<link rel = "stylesheet" type= "text/css" href = "stylesheet.css">
</head>
<body>
<% 	JSONParser j = new JSONParser();
	JSONObject o = (JSONObject)j.parse((String)request.getSession().getAttribute("Question"));
	String question = (String)o.get("question");
	DBQueries q = new DBQueries();
	Long l = (Long)o.get("id");
	JSONArray ja = q.getChoices(l.intValue());
	String c1 = (String)ja.get(0);
	String c2 = (String)ja.get(1);
	String c3 = (String)ja.get(2);
	String c4 = (String)ja.get(3);
	String c5 = (String)ja.get(4);
%>
	<div class = "question-form">
		<form action = "${pageContext.request.contextPath}/web/store" method = "post">
			<div class = "theQuestion">
				<output name = "question" id = "question"><%= question%></output><br><br>
				<input type = "radio" name = "choice" id = "choice" value = "A"><%= c1 %><br>
				<input type = "radio" name = "choice" id = "choice" value = "B"><%= c2 %><br>
				<input type = "radio" name = "choice" id = "choice" value = "C"><%= c3 %><br>
				<input type = "radio" name = "choice" id = "choice" value = "D"><%= c4 %><br>
				<input type = "radio" name = "choice" id = "choice" value = "E"><%= c5 %><br><br>
			</div>
			<input type = "submit" name = "next" id = "next" value = "Next">
		</form>
	</div>

</body>
</html>