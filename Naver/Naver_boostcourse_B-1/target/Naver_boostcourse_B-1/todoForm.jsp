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

<section id="todoForm" class="form_section">
    <form id="todoForm_submit">
        <p class="form_title">어떤 일인가요?</p>
        <input maxlength="24" placeholder="Swift 공부하기(24자까지)" class="form_textInput" type="text" name="title" required>

        <p class="form_title">누가 할 일인가요?</p>
        <input placeholder="홍길동" class="form_textInput" type="text" name="name" required>

        <p class="form_title">우선순위를 선택하세요</p>
        <input class="form_textRadio" id="sequence_1" type="radio" name="sequence" value=1>
        <label class="form_textRadio_label" for="sequence_1">1순위</label>

        <input class="form_textRadio" id="sequence_2" type="radio" name="sequence" value=2>
        <label class="form_textRadio_label" for="sequence_2">2순위</label>

        <input class="form_textRadio" id="sequence_3" type="radio" name="sequence" value=3>
        <label class="form_textRadio_label" for="sequence_3">3순위</label>

        <section class="form_submitSection">
            <input id="prevBtn" class="form_submitSection_prevBtn" type="submit" value="< 이전">
            <input id="deleteBtn" class="form_submitSection_submitBtn" type="submit" value="내용지우기">
            <input id="submitBtn" class="form_submitSection_submitBtn" type="submit" value="제출">
        </section>
    </form>

</section>


</body>
<script type="text/javascript" src="js/todoForm.js"></script>
</html>
