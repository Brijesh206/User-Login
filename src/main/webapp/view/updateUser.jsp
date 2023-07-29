<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Updation Form</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div align="center">

    <h2>Update User</h2>
    <%--@elvariable id="updateUser" type="com.userlogin.model.User"--%>
    <form:form action="${pageContext.request.contextPath}/update/${updateUser.userId}" method="post" modelAttribute="updateUser">
        <form:label path="userName">Full name:</form:label>
        <form:input path="userName" required="required"/><br/>
        <br>
        <form:label path="email">E-mail:</form:label>
        <form:input path="email" required="required"/><br/>
        <br>
        <form:label path="password">Password:</form:label>
        <form:password path="password" required="required"/><br/>
        <br>
        <form:button>Update</form:button>
    </form:form>
</div>
</body>
</html>