document.addEventListener('DOMContentLoaded', function () {
    getDisplayInfoAjax();
});

const DISPLAY_INFO_IMAGE = {
    imageList: 0, // 해당 Display의 이미지 수

    imagePageIndex: 0, // 페이지가 보여주고 있는 이미지 인덱스

    prevBtn: document.querySelector('.btn_prev'),
    nextBtn: document.querySelector('.btn_nxt')
};

function getDisplayInfoAjax() {
    const displayInfoId = new URL(document.URL).searchParams.get("id");

    const http = new XMLHttpRequest();
    http.responseType = 'json';
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            const response = http.response;
            putProductImage(response.displayInfo, response.productImages);
        }
    };

    http.open('GET', `/api/products/${displayInfoId}`);
    http.send();
}

function putProductImage(displayInfo, productImages) { // 이미지 보여주기
    const ul = document.querySelector('.visual_img');
    const li = document.querySelector('#ProductImageTemplate').innerHTML;
    const obj = {
        displayInfo: displayInfo,
        productImages: productImages
    }

    const bindTemplate = Handlebars.compile(li);
    Handlebars.registerHelper('ifImageType', (type, options) => {
        if (type === 'ma' || type === 'et') {
            return options.fn(this);
        }
    });

    ul.innerHTML += bindTemplate(obj);

    DISPLAY_INFO_IMAGE.imageList = ul.childElementCount;
    ValidatePrevAndNext();

    DISPLAY_INFO_IMAGE.prevBtn.addEventListener('click', (e) => {
        MoveToPrevAndNext(e, ul);
    });
    DISPLAY_INFO_IMAGE.nextBtn.addEventListener('click', (e) => {
        MoveToPrevAndNext(e, ul);
    });
}

function MoveToPrevAndNext(e, ul) { //버튼을 누르면 이미지가 앞뒤로 이동
    const title = e.currentTarget.getAttribute('title');

    ul.style.transition = '1s';
    if (title === '다음') {
        ++DISPLAY_INFO_IMAGE.imagePageIndex;
        ul.style.transform = `translateX(-${DISPLAY_INFO_IMAGE.imagePageIndex * 100}%)`;
    } else if (title === '이전') {
        --DISPLAY_INFO_IMAGE.imagePageIndex;
        ul.style.transform = `translateX(-${DISPLAY_INFO_IMAGE.imagePageIndex * 100}%)`;
    }

    ValidatePrevAndNext();
}

function ValidatePrevAndNext() { // 보여주는 리스트에 따라 버튼 off 처리, hidden 처리
    if (DISPLAY_INFO_IMAGE.imageList == 1) {
        DISPLAY_INFO_IMAGE.prevBtn.style.display = 'none';
        DISPLAY_INFO_IMAGE.nextBtn.style.display = 'none';
    }

    console.log(DISPLAY_INFO_IMAGE.imageList);
    console.log('index = ' + (DISPLAY_INFO_IMAGE.imagePageIndex + 1));
}