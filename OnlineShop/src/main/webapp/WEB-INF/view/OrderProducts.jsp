<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: red;">
	<div id="box1"
		style="width: 1400px; height: 360px;padding-top:20px; box-shadow: 0px 0px 110px; border-radius: 6px; background-color: silver; font-size: x-large; margin-top: 30px; margin-left: 30px;">
		<div style="padding-left: 40px">
		<div style="background-color:grey; width: 1400px;height: 340px;padding-bottom: 30px;box-shadow: 0px 0px 20px">
			<th><h2
					style="text-decoration: underline; color: yellow; text-transform: uppercase; font-weight: bold;width: 350px;height:50px;padding-top: 30px">User_Account:</h2>
			</th>
			<th >
				<p style="color: white;padding-left: 20px">User_Id: ${user.getId()}</p>
			</th>
			<th>
				<p style="color: white;padding-left: 20px">User_Name: ${user.getName()}</p>
			</th>
			<th><p style="color: white;padding-left: 20px">Email: ${user.getEmail()}</p></th>
			<th><p style="color: white;padding-left: 20px">Password: ${user.getPassword()}</p></th> <a
				href="${pageContext.request.contextPath}/product/purchasePage?id=${user.getId()} "
				style="padding-left: 300px"><button
					style="margin-left: 800px;margin-bottom:540px; width: 130px; height: 40px; border-radius: 10px; background-color: blue; color: white">BackToPurchase</button></a>
			<hr>	<hr>
			</div>
		</div>

	</div>


	<div
		style="width: 1382px; height: 40px; box-shadow: 0px 0px 110px; border-radius: 6px; background-color: olive; line; margin-top: 80px; margin-left: 55px;">
		<marquee behavior="alternate"
			style="font-size: large; font-family: cursive; text-decoration: underline; color: black;">here
			is your Ordered Products !!!! </marquee>
	</div>
	<table border="5px"
		style="margin-left: 60px; margin-top: 4px; width: 1380px; box-shadow: 0px 0px 70px;">
		<tr style="background-color: purple; color: white">
			<th>ProductId</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Prize</th>
			<th>Product_color</th>
			<th>Model Of the Product</th>
			<th>Cancel_Order</th>

		</tr>

		<c:forEach var="product" items="${products}">

			<tr style="background-color: black;">
				<td style="background-color: purple; color: white">${product.getProductId()}</td>
				<td style="background-color: white;">${product.getProductName()}</td>
				<td style="background-color: white;">${product.getDescription()}</td>
				<td style="background-color: white;">${product.getCost()}</td>
				<td style="background-color: white;">${product.getProductColor()}</td>
				<td style="background-color: white;">${product.getModel()}</td>

				<td style="background-color: white;"><a
					style="text-decoration: none; text-align: center; padding-left: 10px"
					href="canceled/${product.getProductId()}/${user.getId()}">caneclOrder</a></td>

			</tr>
			<br>
		</c:forEach>
	</table><a href="calculate?id=${user.getId()} " style="padding-left: 300px"><button
					style="margin-left: 890px;margin-top:40px; width: 130px; height: 40px; border-radius: 10px; background-color:teal; color: white">generateBill</button></a>
		<label style="text-decoration: underline;font-weight: bold;font-size: xx-large;padding-left: 10px"><%=request.getAttribute("cal")%></label>
			
</body>
</html>