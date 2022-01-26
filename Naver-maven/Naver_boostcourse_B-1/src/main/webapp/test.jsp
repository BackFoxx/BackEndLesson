<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-27
  Time: 오전 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="test" scope="request" value="101"/>
<html>
<head>
    <title>Title</title></head>
<body>
    변수명: ${test} <br>
    <c:if test="${test == 100}">
        test는 100과 같습니다.
    </c:if>
    <c:if test="${test == 101}">
        test는 101과 같습니다.
    </c:if>

</body>
</html>
