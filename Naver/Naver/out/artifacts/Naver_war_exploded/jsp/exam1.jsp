<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-25
  Time: 오후 6:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exam1</title>
</head>
<body>
id: <%=getId()%>
<%!
    String id = "u003";

    public String getId() {
        System.out.println("id = " + id);
        return id;
    }
%>
</body>
</html>
