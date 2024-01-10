<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: teal;">
	<div style="width: 450px;height:104px;background-color:maroon; box-shadow: 0px 0px 20px;margin: 10px auto;border-radius: 20px;margin-top: 140px ">
<h2 style="padding-top: 40px;text-align: center;color: white"><marquee behavior="alternate" loop="1"><%=request.getAttribute("order") %></marquee></h2>
<br>	</div>

<a href="${pageContext.request.contextPath}/product/returnView?id=${user.getId()}"
					style="padding-left: 800px;color: black;"><button
						style="width: 180px; height: 30px; border-radius: 10px;margin-top:30px; background-color:aqua; color: black;font-weight:bold; font-size: large; font-family: sans-serif;">returnToView</button></a>

</body>
</html>