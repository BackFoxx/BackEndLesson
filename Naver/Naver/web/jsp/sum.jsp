<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-25
  Time: 오후 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        int total = 0;
        for(int i = 1; i <= 10; i++){
            total = total + i;
        }
    %>

    1부터 10까지의 합 : <%=total %>

</body>
</html>
