<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-26
  Time: 오전 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("k", 10);
  request.setAttribute("m", true);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
k : ${k} <br>
k + 5 : ${k + 5} <br>
k - 5 : ${k - 5} <br>
k * 5 : ${k * 5} <br>
k / 5 : ${k div 5} <br>

k : ${k} <br>
m : ${m} <br>
!m : ${!m}

</body>
</html>
