<%--
  Created by IntelliJ IDEA.
  User: AlexGarag
  Date: 09.09.2024
  Time: 10:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.loginUser} profile page</title>
</head>
<body>
    <h4>Login: ${user.loginUser}</h4>
    <h4>Name: ${user.nameUser}</h4>
    <h4>ID: ${user.uuidUser}</h4>
    <h4>Password: ${user.nameUser}</h4>
    <img src="data:image/png;base64,${avatar}">
</body>
</html>
