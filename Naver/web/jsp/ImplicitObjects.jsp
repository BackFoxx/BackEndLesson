<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-25
  Time: 오후 7:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>뭄무</title>
</head>
<body>
<%
    StringBuffer url = request.getRequestURL();
    System.out.println("뭉망!");
    PrintWriter writer = response.getWriter();
    writer.print("응애");
%>
</body>
</html>
