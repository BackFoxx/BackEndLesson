<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-25
  Time: 오후 6:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exam2</title>
</head>
<body>

<%
    for (int i = 1; i <= 5; i++) {
%>
<h<%=i%>> 아름다운 한글 </h<%=i%>>
<%
    }
%>

</body>
</html>
