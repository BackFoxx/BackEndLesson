<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-21
  Time: 오후 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$

  <%
    System.out.println("뭄무");
  %>

  <%!
    public void jspInit() {
      System.out.println("인잇!!");
    }

    public void jspDestroy() {
      System.out.println("디스트로이이");
    }
  %>
  </body>
</html>
