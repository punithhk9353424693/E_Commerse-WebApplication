<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: maroon;">
<marquee behavior="alternate" direction="top" style="margin-top: 40px">
<div style="width: 600px;height:50px; box-shadow: 0px 0px 110px;border-radius: 6px;background-color:green; margin-top: 30px;margin-left: 30px;">
<marquee behavior="slide" loop="2" >
<h1 style="text-align: center;color: white;font-size:larger;margin-top: 10px"><%=request.getAttribute("log") %>?</h1></marquee>
</div></marquee>
</body>
</html>