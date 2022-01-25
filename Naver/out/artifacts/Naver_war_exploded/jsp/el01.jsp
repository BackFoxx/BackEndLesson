<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-26
  Time: 오전 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("p1", "page scope value");
    request.setAttribute("r1", "request scope value");
    session.setAttribute("s1", "session scope value");
    application.setAttribute("a1", "application scope value");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

pageContext.getAttribute("p1") : ${pageScope.p1} <br>
request.getAttribute("r1") : ${requestScope.r1} <br>
session.getAttribute("s1") : ${sessionScope.s1} <br>
application.getAttribute("a1") : ${applicationScope.a1} <br>

</body>
</html>
