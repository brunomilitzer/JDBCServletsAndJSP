<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 4/16/2020
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<jsp:useBean id="product" class="br.com.brunomilitzer.trainings.jsp.Product">
    <jsp:setProperty name="product" property="*" />
</jsp:useBean>

Product Details

<br/> Id: <:jsp:getProperty property="id" name="product" />
<br/> Name: <:jsp:getProperty property="name" name="product" />
<br/> Description: <:jsp:getProperty property="description" name="product" />
<br/> Price: <:jsp:getProperty property="price" name="product" />
</body>
</html>
