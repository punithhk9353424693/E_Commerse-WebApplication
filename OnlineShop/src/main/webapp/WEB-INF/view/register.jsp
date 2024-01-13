<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lime;">
	<!-- <div
		style="margin: 80px auto; background-color: white; border-radius: 5px; box-shadow: 0px 0px 10px; width: 390px; height: 350px;
		background-color: silver;">
		>
		<h2 style="text-align: center;color: black; ">User-SignUp-Page</h2>
		
		<form action="registerPage">

			<input type="text" placeholder="Enter Name" name="name"
				required="required"
				style="margin-left: 50px; margin-top: 0px; width: 280px; height: 27px;
				box-shadow: 0px 0px 5px"><br>
			<input type="email" placeholder="Enter Email" name="email"
				required="required"
				style="margin-left: 50px; margin-top: 20px; width: 280px; height: 27px;
					box-shadow: 0px 0px 5px"><br>
			<input type="password" placeholder="Enter unique Passwaord" name="password"
				required="required"
				style="margin-left: 50px; margin-top: 20px; width: 280px; height: 27px;
					box-shadow: 0px 0px 5px"><br>
			<br> <input type="submit" value="signUp"
				style="background-color:olive; width: 190px; height: 30px; border-radius: 5px; margin-left: 150px; color: white
				;">

		</form>
	</div> -->
	
	
	 <script>
        function validatePassword() {
            var password = document.getElementById("password").value;

            // Define regular expressions for each password criteria
            var uppercaseRegex = /[A-Z]/;
            var lowercaseRegex = /[a-z]/;
            var specialCharRegex = /[!@#$%^&*(),.?":{}|<>]/;

            // Check if the password meets all criteria
            if (password.length >= 8 &&
                uppercaseRegex.test(password) &&
                lowercaseRegex.test(password) &&
                specialCharRegex.test(password)) {
                return true;
            } else {
                alert("Password must contain at least 8 characters, including one uppercase letter, one lowercase letter, and one special character.");
                return false;
            }
        }
    </script>
</head>

<body>
    <div style="margin: 80px auto; background-color: white; border-radius: 5px; box-shadow: 0px 0px 10px; width: 390px; height: 350px; background-color: silver;">
        <h2 style="text-align: center;color: black;padding-top: 30px ">User-SignUp-Page</h2>

        <form action="registerPage" onsubmit="return validatePassword()">

            <input type="text" placeholder="Enter Name" name="name" required="required" style="margin-left: 50px; margin-top: 0px; width: 280px; height: 27px; box-shadow: 0px 0px 5px"><br>
            <input type="email" placeholder="Enter Email" name="email" required="required" style="margin-left: 50px; margin-top: 20px; width: 280px; height: 27px; box-shadow: 0px 0px 5px"><br>
            <input type="password" id="password" placeholder="Enter unique Password" name="password" required="required" style="margin-left: 50px; margin-top: 20px; width: 280px; height: 27px; box-shadow: 0px 0px 5px"><br>
            <br> <input type="submit" value="SignUp" style="background-color: olive; width: 190px; height: 30px; border-radius: 5px; margin-left: 150px; color: white;">

        </form>
    </div>
</body>
</html>