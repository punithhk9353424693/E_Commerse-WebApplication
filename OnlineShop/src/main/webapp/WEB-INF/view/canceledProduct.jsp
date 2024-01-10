<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: purple;">
<div style="width: 450px;height:80px;background-color:white;  box-shadow: 0px 0px 20px;margin: 10px auto;border-radius: 20px;margin-top: 140px ">
<h2 style="padding-top: 40px;text-align: center;"><marquee behavior="alternate" style="color: maroon;font-weight: bold;font-size: x-large;margin-bottom: 90px"><%=request.getAttribute("dele") %></marquee></h2>
	</div>

	<a href="${pageContext.request.contextPath}/product/purchasePage?id=${user.getId()}"
					style="padding-left: 800px;color: black;"><button
						style="width: 180px; height: 30px; border-radius: 10px;margin-top:30px; background-color: orange; color: black; font-size: large;font-weight:bold; font-family: sans-serif;">returnToPurchase</button></a>

	
</body>
</html>