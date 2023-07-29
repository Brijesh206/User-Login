<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Testing JSP</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<h1>List of the users</h1>
<table border="2px solid red">
    <tr>
    <th>UserName</th>
    <th>Email</th>
    <th>Operations</th>
    </tr>

    <%--@elvariable id="listUsers" type="com.userlogin.model.User"--%>
    <c:forEach var="user" items="${listUsers}">

        <tr>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>
                <a href="${pageContext.request.contextPath}/remove/${user.userId}">
                    <button>Delete</button>  &nbsp;
                </a>
                <a href="${pageContext.request.contextPath}/updateForm/${user.userId}">
                    <button>Update</button>
                </a>
            </td>
        </tr>


    </c:forEach>

</table>
<br><br>
If You are new user please <a href="${pageContext.request.contextPath}/registerForm">Register</a>
<br><br>
Return to <a href="${pageContext.request.contextPath}/home">Home</a>
</body>
</html>