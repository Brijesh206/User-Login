<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Testing JSP</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<h1>Hello World !</h1>
<a href="${pageContext.request.contextPath}/registerForm">Register</a><br><br>
<a href="${pageContext.request.contextPath}/listUsers">List Users</a><br><br>
</body>
</html>