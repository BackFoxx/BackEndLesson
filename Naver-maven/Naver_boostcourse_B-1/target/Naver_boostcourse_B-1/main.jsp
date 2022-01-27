<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.TodoDto" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-27
  Time: 오전 7:16
  To change this template use File | Settings | File Templates.
--%>
<%
    List<TodoDto> dtos = (List<TodoDto>) request.getAttribute("todo");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <title>Main</title>
</head>
<body>
<nav class="navigation">
    <h2 class="title">나의 해야할 일들</h2>
    <button class="title_todoBtn">새로운 Todo 등록</button>
</nav>
<div class="Sections">

    <section class="Section">
        <div class="Section_title_box">DONE</div>
        <%
            List<TodoDto> doneList = new ArrayList<>();
            for (TodoDto dto : dtos) {
                if (dto.getType().equals("DONE")) {
                    doneList.add(dto);
                }
            }

            request.setAttribute("DONE", doneList);
        %>
        <c:forEach var="donelists" items="${DONE}">
            <div class="Section_todo_box">
                <span class="todo_title">${donelists.title}</span>
                <span class="todo_desc">${donelists.regDate}, ${donelists.name}, ${donelists.sequence}</span>
                <button class="todo_btn">→</button>
            </div>
        </c:forEach>
    </section>

    <section class="Section">
        <div class="Section_title_box">DOING</div>
        <%
            List<TodoDto> doingList = new ArrayList<>();
            for (TodoDto dto : dtos) {
                if (dto.getType().equals("DOING")) {
                    doingList.add(dto);
                }
            }

            request.setAttribute("DOING", doingList);
        %>
        <c:forEach var="doinglists" items="${DOING}">
            <div class="Section_todo_box">
                <span class="todo_title">${doinglists.title}</span>
                <span class="todo_desc">${doinglists.regDate}, ${doinglists.name}, ${doinglists.sequence}</span>
                <button class="todo_btn">→</button>
            </div>
        </c:forEach>
    </section>

    <section class="Section">

        <div class="Section_title_box">TODO</div>
        <%
            List<TodoDto> todoList = new ArrayList<>();
            for (TodoDto dto : dtos) {
                if (dto.getType().equals("TODO")) {
                    todoList.add(dto);
                }
            }

            request.setAttribute("TODO", todoList);
        %>
        <c:forEach var="todolists" items="${TODO}">
            <div class="Section_todo_box">
                <span class="todo_title">${todolists.title}</span>
                <span class="todo_desc">${todolists.regDate}, ${todolists.name}, ${todolists.sequence}</span>
                <button class="todo_btn">→</button>
            </div>
        </c:forEach>
    </section>

</div>
</body>
</html>
