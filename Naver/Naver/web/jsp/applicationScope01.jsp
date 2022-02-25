<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-25
  Time: 오후 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scope</title>
</head>
<body>
<%
    try{
        int value = (int)application.getAttribute("value");
        value = value + 2;
        application.setAttribute("value", value);
%>
<h1><%=value %></h1>
<%
}catch(NullPointerException ex){
%>
<h1>설정된 값이 없습니다.</h1>
<%
    }
%>
</body>
</html>
