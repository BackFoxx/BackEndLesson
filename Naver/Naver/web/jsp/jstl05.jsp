<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-26
  Time: 오후 6:01
  To change this template use File | Settings | File Templates.
--%>
<c:import url="https://www.google.co.uk/" var="urlValue" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${urlValue}
</body>
</html>
