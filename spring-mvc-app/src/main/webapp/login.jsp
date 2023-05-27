<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${msg}</h2>
<form action="login" method="post">
<label>Phone :</label><input type="tel" name="phone"><br>
<label>Password :</label><input type="password" name="password"><br>
<input type="submit" value="Login"><br>
</form>
<a href="register.jsp">Click here to Register</a>
</body>
</html>