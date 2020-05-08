<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 4/17/2020
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Cout Demo</title>
</head>
<body>
<c:out value="${10 + 9}"/>
<c:set var="testScore" value="${80}" scope="session" />
<c:out value="${testScore}" />

<c:if test="${testScore >= 80}">
    <p>Your score is Awesome <c:out value="${testScore}" /></p><br />
</c:if>

<c:choose>
    <c:when test="{testScore >= 80}">
        A Grade<br />
    </c:when>
    <c:when test="{testScore >= 60 && testScore < 80}">
        B Grade<br />
    </c:when>
    <c:otherwise>
        C Grade<br />
    </c:otherwise>
</c:choose>

<c:forEach var="i" begin="1" end="3">
    <c:out value="${i}" /> <br />
</c:forEach>

<%
    List<String> studentNames = new ArrayList<>();
    studentNames.add( "Bruno" );
    studentNames.add( "Vanessa" );
    studentNames.add( "Tales" );

    request.setAttribute( "studentNames", studentNames );
%>

<c:forEach var="studentName" items="${studentNames}">
    <c:out value="${studentName}" /> <br />
</c:forEach>

<c:remove var="testScore" />
After Removal the value is: <c:out value="${testScore}" /><br />

<c:set var="accountBalance" value="123.456" />

<fmt:parseNumber var="i" type="number" value="${accountBalance}"/>
<p>Ammount is: <c:out value="${i}" /></p><br />

<c:set var="accountBalance" value="7777.4567" />
Formated Number 1: <fmt:formatNumber value="${accountBalance}" type="currency" /><br />
Formated Number 2: <fmt:formatNumber value="${accountBalance}" type="number" maxFractionDigits="2" /><br />
Formated Number 3: <fmt:formatNumber value="${accountBalance}" type="number" maxIntegerDigits="2" /><br />
Formated Number 4: <fmt:formatNumber value="${accountBalance}" type="percent" /><br />
Formated Number 4: <fmt:formatNumber value="${accountBalance}" type="number" pattern="R$ ####.##" /><br />

<c:set var="myDate" value="12-07-2020" />
<fmt:parseDate var="parsedDate" value="${myDate}" pattern="dd-MM-yyyy" />
<p><c:out value="${parsedDate}" /></p><br />

</body>
</html>
