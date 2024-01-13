<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="../resources/styles/adding.css">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="adding.css">
</head>
<body style="background-color: lime;">
	<div id="box1"
		style="width: 1400px; height: 280px; box-shadow: 0px 0px 110px; border-radius: 6px; background-color: teal; font-size: x-large; margin-top: 30px; margin-left: 30px;">
		<div style="padding-left: 40px">
			<th><h2
					style="text-decoration: underline; color: yellow; text-transform: uppercase; font-weight: bold;">User_Account:</h2>
			</th>
			<th>
				<p>User_Id: ${user.getId()}</p>
			</th>
			<th>
				<p>User_Name: ${user.getName()}</p>
			</th>
			<th><p>Email: ${user.getEmail()}</p></th>
			<th><p>Password: ${user.getPassword()}</p></th>
			<div style="margin-top: -240px;height: 200px">
				<a href="${pageContext.request.contextPath}/product/viewOrders?id=${user.getId()}"
					style="padding-left: 1100px; color: black;"><button
						style="width: 180px; height: 30px; border-radius: 10px;margin-top:20px; background-color: purple; color: white; font-size: large; font-family: sans-serif;">viewOrders!!</button></a>
				<a href="${pageContext.request.contextPath}/logout" target="_top"
					style="padding-left: 1100px;  color: red;"><button
						style="width: 180px; height: 30px; border-radius: 10px; background-color: purple; color: white; font-size: large; font-family: sans-serif;margin-top:30px;">LogOut?</button></a>
				<a href="${pageContext.request.contextPath}/product/deleteUser?id=${user.getId()}"
					style="padding-left: 1100px;color: black;"><button
						style="width: 180px; height: 30px; border-radius: 10px;margin-top:30px; background-color: purple; color: white; font-size: large; font-family: sans-serif;">DeleteAccount?</button></a>
<br>


			</div>
		</div>

	</div>


	<br>
	<div
		style="width: 1400px; height: 40px; box-shadow: 0px 0px 110px; border-radius: 6px; background-color: maroon; line margin-top: 30px; margin-left: 30px;">
		<marquee behavior="alternate"
			style="font-size: large; font-family: cursive; text-decoration: underline; color: white">Purchase
			Your Products Here!!!!! </marquee>
	</div><%-- <p style="padding-left: 1000px;font-size:larger; ">To View How Many Users Are using Shoping Cart:</p> <a href="${pageContext.request.contextPath}/product/findAllUsers?id=${user.getId()}"
					style="padding-left: 1270px;">Click here</a> --%>
	
	<table border="7px"
		style="margin-left: 60px; margin-top: 5px; width: 1380px; box-shadow: 0px 0px 70px;">
		<tr style="background-color: olive;color: white">
			<th>ProductId</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Prize</th>
			<th>add Tocart</th>
			<th>View_Product</th>

		</tr>

		<c:forEach var="product" items="${products}">

			<tr style="background-color:  white;color: black;">
				<td style="padding-left: 8px">${product.getProductId()}</td>
				<td style="padding-left: 8px">${product.getProductName()}</td>
				<td style="padding-left: 8px">${product.getDescription()}</td>
				<td style="padding-left: 8px">${product.getCost()}</td>
				<td ><a
					style="text-decoration: none; text-align: center; padding-left: 10px;"
					href="${pageContext.request.contextPath}/product/redirectTopay/${product.getProductId()}/${user.getId()}">purchase</a></td>
				<td ><a
					style="text-decoration: none; text-align: center; padding-left: 10px;"
					href="${pageContext.request.contextPath}/product/viewProduct/${product.getProductId()}/${user.getId()}">ViewProduct</a></td>

			</tr>
			</div>
			<br>
		</c:forEach>
	</table>
</body>
</html>