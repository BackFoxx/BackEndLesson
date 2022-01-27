<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-27
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/todoForm.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<body>
<h1 class="title">할일 등록</h1>

<section class="form_section">
    <form method="post" action="/TodoAddServlet">
        <p class="form_title">어떤 일인가요?</p>
        <input class="form_textInput" type="text" name="title">
    </form>

</section>

</body>
</html>
