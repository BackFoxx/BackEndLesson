<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-27
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/todoForm.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<body>
<h1 class="title">할일 등록</h1>

<section class="form_section">
    <form id="todoForm_submit" action="/TodoAddServlet" method="post">
        <p class="form_title">어떤 일인가요?</p>
        <input maxlength="24" placeholder="Swift 공부하기(24자까지)" class="form_textInput" type="text" name="title">

        <p class="form_title">누가 할 일인가요?</p>
        <input placeholder="홍길동" class="form_textInput" type="text" name="name">

        <p class="form_title">우선순위를 선택하세요</p>
        <input id="sequence_1" type="radio" name="sequence" value=1>
        <label class="form_textRadio_label" for="sequence_1">1순위</label>

        <input id="sequence_2" type="radio" name="sequence" value=2>
        <label class="form_textRadio_label" for="sequence_2">2순위</label>

        <input id="sequence_3" type="radio" name="sequence" value=3>
        <label class="form_textRadio_label" for="sequence_3">3순위</label>

        <section class="form_submitSection">
            <input class="form_submitSection_prevBtn" type="submit" value="< 이전">
            <input class="form_submitSection_submitBtn" type="submit" value="제출">
            <input class="form_submitSection_submitBtn" type="submit" value="내용지우기">
        </section>
    </form>

</section>


</body>
</html>
