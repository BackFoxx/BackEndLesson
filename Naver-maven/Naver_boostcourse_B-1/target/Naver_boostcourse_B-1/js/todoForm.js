// 우선순위 선택
const sequenceInputRadio = document.getElementsByName('sequence');
var selectSequence;
for (const SIR of sequenceInputRadio) {
    SIR.addEventListener('change', setSequence)
}

function setSequence(event) {
    selectSequence = event.target.value;
}

// 제출 버튼
const submit = document.getElementById('todoForm');
submit.addEventListener('submit', function (e) {
    e.preventDefault();
    if (selectSequence === undefined) {
        alert("우선순위를 정해주세요");
        return;
    }
    var params = new Object();
    params.title = document.getElementsByName('title')[0].value;
    params.name = document.getElementsByName('name')[0].value;
    params.sequence = selectSequence;

    const http = new XMLHttpRequest();
    http.open('POST', '/add');
    http.setRequestHeader('Content-type', 'application/json');

    http.onreadystatechange = () => {
        if (http.readyState === http.DONE) {
            if (http.status === 200 || http.status === 201) {
                location.href = '/main';
            } else {
                console.log("Fail");
            }
        }
    };

    console.log(JSON.stringify(params));
    http.send(JSON.stringify(params));
});

// 내용 지우기 버튼
const deleteBtn = document.querySelector('#deleteBtn');
deleteBtn.addEventListener('click', function (e) {
    e.preventDefault();
    const inputTexts = document.getElementsByClassName('form_textInput');
    const inputRadios = document.getElementsByClassName('form_textRadio');

    for (const inputText of inputTexts) {
        inputText.value = '';
    }

    for (const inputRadio of inputRadios) {
        inputRadio.checked = false;
    }
})

// 이전 버튼
const prevBtn = document.getElementById('prevBtn');
prevBtn.addEventListener('click', function (e) {
    e.preventDefault();
    location.href = "/main";
});
