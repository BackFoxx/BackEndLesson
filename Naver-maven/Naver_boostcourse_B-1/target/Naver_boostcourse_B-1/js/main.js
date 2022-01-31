// class명이 todo_btn인 모든 "->" 버튼에 addEventListener가 적용되도록 forEach 사용
const todo_btn = document.querySelectorAll('.todo_btn');
todo_btn.forEach((e) => e.addEventListener('click', todoType));

// "->"버튼을 누르면 db에 type 변경를 요청하는 로직
function todoType(e) {
    const http = new XMLHttpRequest();
    const todoId = e.target.getAttribute("todo_id");

    http.onreadystatechange = () => {
        if (http.readyState === http.DONE) {
            if (http.status === 200 || http.status === 201) {
                //1. 요청 성공시 수행
                console.log("SUCCESS!");
                todoMainUpdate(e.target);
            } else {
                console.log("Fail");
            }
        }
    };

    //0. TodoTypeServlet에 /type/{Id} 형식으로 요청
    http.open('GET', '/type/' + todoId);
    http.send();
}

// 화면에서 카드가 업데이트된 type의 섹션으로 이동하는 로직
function todoMainUpdate(btn) {
    const Id = btn.getAttribute("todo_id");
    //0. 카드가 소속된 Section이 todo인지, doing인지 파악하여 카드를 이동
    if (btn.closest('.Section').getAttribute('id') === 'sectionTodo') {
        const todoSection = document.getElementById('todoList' + Id);
        document.getElementById("sectionDoing").appendChild(todoSection);
    } else if (btn.closest('.Section').getAttribute('id') === 'sectionDoing') {
        const doingSection = document.getElementById('todoList' + Id);
        document.getElementById("sectionDone").appendChild(doingSection);
        //1. doing에서 done으로 이동한 카드는 버튼이 소멸
        btn.remove();
    }
}

