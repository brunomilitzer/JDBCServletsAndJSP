<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 4/16/2020
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    int result = (Integer) request.getAttribute( "result" );

    out.print( "<b>The Average is: " + result + "</b>" );
%>
</body>
</html>
