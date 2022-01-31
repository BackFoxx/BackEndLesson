// 선택된 radio형 input을 selectSequence 변수에 저장
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
    //0. 우선순위 미선택시 실행
    if (selectSequence === undefined) {
        alert("우선순위를 정해주세요");
        return;
    }
    
    //1. 서블릿으로 전송할 객체 생성(getElementsByName은 배열을 반환하므로 0번째 인덱스의 값을 저장)
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
                //3. 성공시 /main으로 GET요청 (redirect를 사용해도 페이지 이동이 되지 않아 location.href 사용)
                location.href = '/main';
            } else {
                console.log("Fail");
            }
        }
    };

    //2. 객체를 json으로 바꾸어 POST로 요청
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
    //(XMLHttpRequest GET요청을 해도 페이지 이동이 되지 않아 location.href로 /main에 GET요청 )
    location.href = "/main";
});
