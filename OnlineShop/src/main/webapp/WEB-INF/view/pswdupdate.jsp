<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: purple;">
<div style="width: 450px;height:180px;background-color: yellow;box-shadow: 0px 0px 20px;margin: 10px auto;border-radius: 20px;margin-top: 140px ">
<h2 style="padding-top: 40px;text-align: center;"><%=request.getAttribute("up") %></h2>
<br><br>
<a href="justin" style="padding-left: 300px;font-size: large;"><button style="height: 30px;box-shadow: 0px 0px 10px;border-radius: 6px;color: white;background-color: red;">ReturnToLogin!!! </button></a>
</div>
</body>
</html>