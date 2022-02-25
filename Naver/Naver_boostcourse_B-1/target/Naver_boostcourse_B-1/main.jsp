<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-01-27
  Time: 오전 7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <title>Main</title>
</head>

<body>

    <nav class="navigation">
        <h2 class="Navigation_title">나의 해야할 일들</h2>
        <a href="/todo" class="Navigation_title_todoBtn">새로운 Todo 등록</a>
    </nav>

    <div class="Sections">

        <section id="sectionDone" class="Section">
            <div class="Section_title_box">DONE</div>
            <c:forEach var="donelists" items="${requestScope.todo}">
                <c:if test="${donelists.type eq 'DONE'}">
                    <section id='todoList${donelists.id}'>
                        <div class="Section_describe_box">
                            <span class="todo_title">${donelists.title}</span>
                            <span class="todo_desc">${donelists.regDate}, ${donelists.name}, 우선순위 ${donelists.sequence}</span>
                        </div>
                    </section>
                </c:if>
            </c:forEach>
        </section>

        <section id="sectionDoing" class="Section">
            <div class="Section_title_box">DOING</div>
            <c:forEach var="doinglists" items="${requestScope.todo}">
                    <c:if test="${doinglists.type eq 'DOING'}">
                        <section id='todoList${doinglists.id}'>
                            <div class="Section_describe_box">
                                <span class="todo_title">${doinglists.title}</span>
                                <span class="todo_desc">${doinglists.regDate}, ${doinglists.name}, 우선순위 ${doinglists.sequence}</span>
                                <button todo_id="${doinglists.id}" class="todo_btn">→</button>
                            </div>
                        </section>
                    </c:if>
            </c:forEach>
        </section>

        <section id="sectionTodo" class="Section">
            <div class="Section_title_box">TODO</div>
            <c:forEach var="todolists" items="${requestScope.todo}">
                    <c:if test="${todolists.type eq 'TODO'}">
                        <section id='todoList${todolists.id}'>
                            <div class="Section_describe_box">
                                <span class="todo_title">${todolists.title}</span>
                                <span class="todo_desc">${todolists.regDate}, ${todolists.name}, 우선순위 ${todolists.sequence}</span>
                                <button todo_id="${todolists.id}" class="todo_btn">→</button>
                            </div>
                        </section>
                    </c:if>
            </c:forEach>
        </section>

    </div>

    <script type="text/javascript" src="js/main.js"></script>

</body>
</html>

