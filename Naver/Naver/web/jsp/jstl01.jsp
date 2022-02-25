<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-26
  Time: 오전 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="value1" scope="request" value="Kang"/>
<html>
<head>
    <title>JSTL01</title>
</head>
<body>
나의 성 : ${value1} <br>
<c:remove var="value1" scope="request"/>
나의 성 : ${value1} <br>
</body>
</html>
