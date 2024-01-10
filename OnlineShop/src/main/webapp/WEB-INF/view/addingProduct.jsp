<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Photo Upload</title>
</head>
<body>

<h2>Upload a Product</h2>

<form action="saver">
 <input type="text" name="productName" placeholder="Enter product name" required/><br>
   <input type="text" name="description" placeholder="Enter description" required="required"><br>
  <input type="text" name="cost" placeholder="enter cost of the product" required="required"><br>
    <input type="text" name="productColor" placeholder="enter color of the product" required="required"><br>
    <input type="text" name="model" placeholder="enter Model of the product" required="required"><br>
  
    <br/>
    <input type="submit" value="Upload"/>
</form>
</body>
</html>