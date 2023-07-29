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
User Added Successfully!!<br><br>
<a href="${pageContext.request.contextPath}/listUsers">Click here</a> to see existing Users
</body>
</html>