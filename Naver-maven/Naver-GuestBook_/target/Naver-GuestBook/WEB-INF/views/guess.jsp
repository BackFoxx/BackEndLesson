<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-02-23
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>숫자 맞추기 겜</title>
</head>
<body>
    <h1>숫자 맞추기 게임</h1>
    <hr>
    <h1>${message}</h1>
    <c:if test="${sessionScope.count != null}">
        <form method="get" action="guess">
            1부터 100사이의 숫자로 맞춰주세요.<br>
            <input type="text" name="number"><br>
            <input type="submit" value="확인">
        </form>
    </c:if>
</body>
</html>
