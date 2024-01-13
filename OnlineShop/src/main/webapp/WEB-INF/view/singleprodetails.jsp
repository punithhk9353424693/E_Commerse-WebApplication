<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: aqua;">
	
	<div
		style="background-color: olive; width: 800px; height: 600px; box-shadow: 0px 0px 40px; border-radius: 10px; margin-left: 240px; margin-top: 40px">
		<h2
			style="text-decoration: underline; color: white; text-transform: uppercase; font-weight: bold;padding-top: 40px">Product
			Information:</h2>
		<tr style="background-color: maroon;">
			<button style="margin-left: 130px; border-radius: 10px;width: 500px;margin-top: 40px;background-color: maroon;"><th>
				<p
					style="padding-right: 60px; color: white; font-family: sans-serif; font-size: larger;">Product_Id
					: ${product.getProductId()}</p>
			</th></button>
			<br>
			<button style="margin-left: 130px; border-radius: 10px;width: 500px;background-color: maroon;"><th>
				<p
					style="padding-left: 0px; color: white; font-family: sans-serif; font-size: larger;">Product_Category
					: ${product.getProductName()}</p>
			</th></button>
			<br>
			<button style="margin-left: 130px; border-radius: 10px;width: 500px;background-color: maroon;"><th>
				<p
					style="padding-right: 20px; color: white; font-family: sans-serif; font-size: larger;">Product_name
					: ${product.getDescription()}</p>
			</th></button>
			<br>
			<button style="margin-left: 130px; border-radius: 10px;width: 500px;background-color: maroon;"><th>
				<p
					style="padding-left: 0px; color: white; font-family: sans-serif; font-size: larger;">Product_Cost
					: ${product.getCost()}</p>
			</th></button>
			<br>
			<button style="margin-left: 130px; border-radius: 10px;width: 500px;background-color: maroon;"><th>
				<p style="padding-right:65px; color: white; font-family: sans-serif; font-size: larger;padding-left: 137px"><th>
			
					Product_Color
					: ${product.getProductColor()}</p>
			</th></button>
			<br>
			<button style="margin-left: 130px; border-radius: 10px;width: 500px;background-color: maroon;"><th>
				<p
					style="padding-right: 30px; color: white; font-family: sans-serif; font-size: larger;">Product_Model
					: ${product.getModel()}</p>
			</th></button>
			
		</tr><br><br>
		<a href="${pageContext.request.contextPath}/product/redirectTopay/${product.getProductId()}/${user.getId()}" style="margin-left: 390px"><button style="width: 190px;height:40px;border-radius: 6px;background-color:yellow; color:wgite; padding-left: 190"> purchase</button></a>
	</div>


</body>
</html>