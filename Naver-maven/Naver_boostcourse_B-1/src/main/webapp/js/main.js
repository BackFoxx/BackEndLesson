var todo_btn = document.querySelectorAll('.todo_btn');
todo_btn.forEach((e) => e.addEventListener('click', todoType));

function todoType(e) {
    const http = new XMLHttpRequest();
    const todoId = e.target.getAttribute("todo_id");

    http.onreadystatechange = () => {
        if (http.readyState === http.DONE) {
            if (http.status === 200 || http.status === 201) {
                console.log("SUCCESS!");
                todoMainUpdate(e.target);
            } else {
                console.log("Fail");
            }
        }
    };

    http.open('GET', '/type/' + todoId);
    http.send();
}

function todoMainUpdate(btn) {
    const parent = btn.parentElement.parentElement;
    const className = parent.getAttribute('id');

    console.log(className);
    const updatedSection = '<div class="Section_todo_box">\n' +
        '                    <span class="todo_title">${todolists.title}</span>\n' +
        '                    <span class="todo_desc">${todolists.regDate}, ${todolists.name}, ${todolists.sequence}</span>\n' +
        '                    <button todo_id="${todolists.id}" class="todo_btn">→</button>\n' +
        '                </div>'
    if (className === 'Section_todo') {
        parent.insertAdjacentHTML("beforeend", updatedSection);
    }
}