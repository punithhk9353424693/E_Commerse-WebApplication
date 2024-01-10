<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: purple;">
<div
		style="margin: 70px auto; background-color: lime; border-radius: 5px; box-shadow: 0px 0px 10px; width: 390px; height: 370px">
		<h2 style="text-align: center; padding-top: 44px;">UpdatePassword here!!</h2>
		<form action="userUpdate" >
			<input type="text" placeholder="Enter userId" name="id" required="required"
				style="margin-left: 50px; margin-top: 20px; width: 280px; height: 27px; border-radius: 4px;box-shadow:20px 1px 5px 3px"><br>
			<input type="password" placeholder="Enter new password" name="password" required="required"
				style="margin-left: 50px; margin-top: 20px; width: 280px; height: 27px; border-radius: 4px;box-shadow:20px 1px 5px 3px"><br>
			<br>		<hr style="background-color: black; height: 2px"> 
			<input type="submit" value="update"
				style="margin-left: 50px; margin-top: 20px; width: 90px; height: 30px; border-radius: 5px; background-color: blue; color: white">
			
		</form>
	</div>
</body>
</html>