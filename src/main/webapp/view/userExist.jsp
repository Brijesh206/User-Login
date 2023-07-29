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
User is already exist with this email. Please try with different email.
<a href="${pageContext.request.contextPath}/registerForm">Register</a>
<br><br>
<a href="${pageContext.request.contextPath}/listUsers">Click here</a> to see existing Users
<br><br>
Return to <a href="${pageContext.request.contextPath}/home">Home</a>
</body>
</html>