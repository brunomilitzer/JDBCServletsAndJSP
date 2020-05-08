<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 4/16/2020
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addition of two numbers</title>
</head>
<body>

<%
    int num1 = Integer.parseInt( request.getParameter( "number1" ) );
    int num2 = Integer.parseInt( request.getParameter( "number2" ) );
%>

Sum of <%= num1 %> and <%= num2 %> is <%= num1 + num2 %>
</body>
</html>
