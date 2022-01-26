<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-26
  Time: 오후 5:50
  To change this template use File | Settings | File Templates.
--%>
<c:set var="score" scope="request" value="83"/>
<%
    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    list.add("!!!!");

    request.setAttribute("list", list);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${score >= 90}">
        A학점입니다.
    </c:when>
</c:choose>
<%--choose문법--%>

<c:forEach items="${list}" var="item" begin="1">
    ${item} <br>
</c:forEach>

</body>
</html>
