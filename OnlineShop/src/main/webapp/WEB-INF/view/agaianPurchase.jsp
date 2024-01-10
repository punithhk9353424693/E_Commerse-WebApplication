<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: silver;">
	
	<div
		style="background-color:orange; width: 1300px; height: 600px; box-shadow: 0px 0px 40px; border-radius: 10px; margin-left: 100px; margin-top: 40px">
		<div style="background-color:yellow;height:80px;margin-top: 30px;box-shadow: 20px 10px 10px"> <h2
			style=" text-decoration: underline; color: black; text-transform: uppercase; font-weight: bold; padding-top: 40px;padding-left: 30px"><%=request.getAttribute("view")%>:
		</h2></div>
		<marquee behavior="alternate" loop="1">
		<tr >
			<button
				style="margin-left: 130px; border-radius: 10px; width: 500px; margin-top: 40px; background-color:purple;font-weight: bold;box-shadow: 20px 10px 20px">
				<th>
					<p
						style="padding-right: 60px; color: white; font-family: sans-serif; font-size: larger;">Product_Id
						: ${product.getProductId()}</p>
				</th>
			</button>
			<br>
			<button
				style="margin-left: 130px; border-radius: 10px; width: 500px; background-color: purple;font-weight: bold;box-shadow: 20px 10px 20px">
				<th>
					<p
						style="padding-left: 0px; color: white; font-family: sans-serif; font-size: larger;">Product_Category
						: ${product.getProductName()}</p>
				</th>
			</button>
			<br>
			<button
				style="margin-left: 130px; border-radius: 10px; width: 500px; background-color: purple;font-weight: bold;box-shadow: 20px 10px 20px">
				<th>
					<p
						style="padding-right: 20px; color: white; font-family: sans-serif; font-size: larger;">Product_name
						: ${product.getDescription()}</p>
				</th>
			</button>
			<br>
			<button
				style="margin-left: 130px; border-radius: 10px; width: 500px; background-color: purple;font-weight: bold;box-shadow: 20px 10px 20px">
				<th>
					<p
						style="padding-left: 10px; color: white; font-family: sans-serif; font-size: larger;">Product_Cost
						: ${product.getCost()}</p>
				</th>
			</button>
			<br>
			<button
				style="margin-left: 130px; border-radius: 10px; width: 500px; background-color: purple;font-weight: bold;box-shadow: 20px 10px 20px">
				<th>
					<p
						style="padding-right: 35px; color: white; font-family: sans-serif; font-size: larger;">
						<th>Product_Color : ${product.getProductColor()}
					</p>
				</th>
			</button>
			<br>
			<button
				style="margin-left: 130px; border-radius: 10px; width: 500px; background-color: purple;font-weight: bold;box-shadow: 20px 10px 20px">
				<th>
					<p
						style="padding-right: 30px; color: white; font-family: sans-serif; font-size: larger;">Product_Model
						: ${product.getModel()}</p>
				</th>
			</button>

		</tr></marquee><br><br>
		<a
			href="${pageContext.request.contextPath}/product/back/${user.getId()}"
			style="margin-left: 240px"><button
				style="width: 190px; height: 40px; border-radius: 6px; background-color: black; color: white; padding-left: 190">
				Back</button></a>
				
				 <a
			href="${pageContext.request.contextPath}/product/purchaseIt?productId=${product.getProductId()}&id=${user.getId()}"
			style="margin-left: 0px"><button
				style="width: 190px; height: 40px; border-radius: 6px; background-color: white; color: black; padding-left: 170">
				PurchaseAgain</button></a>

	</div>



</body>
</html>