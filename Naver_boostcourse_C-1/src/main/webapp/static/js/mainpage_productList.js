const categoryBtn = document.querySelector('.event_tab_lst'); // 카테고리 리스트
const moreBtn = document.querySelector('.more'); // 더보기 버튼

document.addEventListener('DOMContentLoaded', function () { //DomContent 로딩 완료 후 실행
    getProductAndCount(0, 0); // '전체리스트' 리스트를 가져와 보여줌

    categoryBtn.addEventListener('click', function (e) {
        selectCategory(e);
    }); // 카테고리 별로 버튼 누르면 실행

    moreBtn.addEventListener('click', function (e) {
        setMoreProductList(e);
    }); // '더보기' 버튼 누르면 실행
})

/*
* 카테고리 버튼
*/

var contentStart = 0; // ProductController -> getProductList의 start 파라미터로 들어갈 변수
var selectedCategory; // 선택된 카테고리 아이디를 저장할 변수

function selectCategory (e) {
    const categoryBtn = e.target.closest('li');
    const categoryId = categoryBtn.getAttribute('data-category'); // 선택된 카테고리 아이디
    contentStart = 0; // 버튼을 누르면 리스트를 0번부터 다시 보여주도록 설정
    getProductAndCount(categoryId, contentStart)

    for (const li of e.target.closest('ul').children) {
        li.firstElementChild.className = 'anchor';
    }
    e.target.closest('a').className = 'anchor active'; // 활성화된 버튼 css 바꾸기

}

const content = document.querySelector('#itemList').innerHTML; // 각각의 리스트
const bindTemplate = Handlebars.compile(content);

/*
* 리스트 가져오기
*/

var totalCount;

function getProductAndCount(categoryId, start) {
    var http = new XMLHttpRequest();
    http.responseType = 'json';
    http.onreadystatechange = function (ev) {
        if (http.readyState === 4 && http.status === 200) {
            const response = http.response;
            totalCount = response['totalCount'];

            setTotalCount(totalCount);
            setProductList(response['items'], categoryId);
        }
    };

    http.open("GET", `/api/products?categoryId=${categoryId}&start=${start}`);
    http.send()
}

function setTotalCount(totalCount) {
    var text = document.querySelector(".event_lst_txt .pink");
    text.innerHTML = totalCount+'개';
} // 바로 예약 가능한 행사가 totalCount개 있습니다.

function setProductList(items, categoryId) {
    const boxes = document.querySelectorAll(".lst_event_box");
    const length = items.length;
    var number = 0; //lst_event_box 2개를 왔다갔다 하며 리스트가 생성되도록

    if (contentStart === 0) {
        boxes.forEach((box) => {
            box.innerHTML = '';
        });
    } // 더보기 버튼이 아닌 카테고리 버튼을 눌러서 리스트를 보여주는 경우 원래 진열되어 있던 리스트를 지운 후 실행되도록 설정

    items.forEach((item) => {
        const obj = {
            description: item.productDescription,
            placeName: item.placeName,
            content: item.productContent,
            productImageUrl: item.productImageUrl,
            displayInfoId: item.displayInfoId
        }

        boxes[number].innerHTML += bindTemplate(obj);

        if (number === 0) {
            number = 1;
        }
        else if (number === 1) {
            number = 0;
        }
    });

    selectedCategory = categoryId;
    contentStart += length; // 더보기 버튼을 눌렀을 때 이미 보여준 리스트의 다음 차례부터 가져오도록 설정

    validateMoreBtn();
}

/*
* 더보기 버튼
*/

function setMoreProductList() {
    getProductAndCount(selectedCategory, contentStart);
} // 더보기 버튼을 눌렀을 때 실행

function validateMoreBtn() {
    if (totalCount <= contentStart) {
        moreBtn.style.display = 'none';
    } else {
        moreBtn.style.display = 'inline';
    }
} // 이미 보여준 리스트가 카테고리 내의 전체 리스트 개수와 같거나 더 많은 경우 버튼이 소멸