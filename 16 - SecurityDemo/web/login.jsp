<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 4/17/2020
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="j_security_check" method="post">
        User Name: <input name="j_username" /><br />
        Password: <input type="password" name="j_password" /><br />
        <input type="submit" value="submit" />
    </form>
</body>
</html>
