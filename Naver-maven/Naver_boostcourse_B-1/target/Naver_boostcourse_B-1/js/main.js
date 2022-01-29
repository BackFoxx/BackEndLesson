var todo_btn = document.querySelectorAll('.todo_btn');
todo_btn.forEach((e) => e.addEventListener('click', todoType));

function todoType(e) {
    const http = new XMLHttpRequest();
    const todoId = e.target.getAttribute("todo_id");

    http.onreadystatechange = (e) => {
        if (http.readyState === http.DONE) {
            if (http.status === 200 || http.status === 201) {
                console.log("SUCCESS!");
            } else {
                console.log("Fail");
            }
        }
    };

    http.open('GET', '/type/' + todoId);
    http.send();
}

function todoMainUpdate(e) {
}