<%--
  Created by IntelliJ IDEA.
  User: AlexGarag
  Date: 08.09.2024
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <jsp:include page="_header.jsp"/>
    <div class="container">
        <div class="row justify-content-center">
            <form class="col-4" action="/user/registration" method="post" enctype="multipart/form-data">
                <div class="alert alert-warning" role="alert">
                    ${message}
                </div>
                <div class="mb-3">
                    <label for="inputName" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" id="inputName">
                </div>
                <div class="mb-3">
                    <label for="inputLogin" class="form-label">Login</label>
                    <input type="text" name="login" class="form-control" id="inputLogin">
                </div>
                <div class="mb-3">
                    <label for="inputPassword" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="inputPassword">
                </div>
                <div class="mb-3">
                    <label for="formFile" class="form-label">Default file input example</label>
                    <input class="form-control" name="avatar" type="file" id="formFile">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</body>
</html>
