const DISPLAY_INFO_IMAGE = {
    imageList: 0, // 해당 Display의 이미지 수
    imagePageIndex: 0, // 페이지가 보여주고 있는 이미지 인덱스

    prevBtn: document.querySelector('.btn_prev'),
    nextBtn: document.querySelector('.btn_nxt'),

    currentImagePage: document.querySelector('.num'),
    totalImagePage: document.getElementsByClassName('num off')[0]
};

function GetAjaxToProductImageJs() { //DisplayInfo GET요청 보내기
    const response = AJAX.displayInfoAjax;
    putProductImage(response.displayInfo, response.productImages);
}

function putProductImage(displayInfo, productImages) { // 이미지 보여주기
    const ul = document.querySelector('.visual_img');
    const li = document.querySelector('#ProductImageTemplate').innerHTML;
    const images = productImages.filter(el => el.type === 'ma' || el.type === 'et');

    const obj = {
        displayInfo: displayInfo,
        productImages: function () {
            if (images.length > 2) {
                return [images[0], images[1], images[0], images[1]];
            } else {
                return [images[0]];
            }
        },
    }


    const bindTemplate = Handlebars.compile(li);
    ul.innerHTML += bindTemplate(obj);

    if (ul.childElementCount > 2) {
        DISPLAY_INFO_IMAGE.imageList = 2;
    } else {
        DISPLAY_INFO_IMAGE.imageList = 1;
    }

    ValidatePrevAndNext();

    DISPLAY_INFO_IMAGE.prevBtn.addEventListener('click', (e) => {
        MovePrevAndNext(e, ul);
    });
    DISPLAY_INFO_IMAGE.nextBtn.addEventListener('click', (e) => {
        MovePrevAndNext(e, ul);
    });
}

function putImagePage() {
    DISPLAY_INFO_IMAGE.currentImagePage.innerHTML = `${DISPLAY_INFO_IMAGE.imagePageIndex + 1}`;
    if (DISPLAY_INFO_IMAGE.imageList > 2) {
        DISPLAY_INFO_IMAGE.totalImagePage.firstElementChild.innerHTML = '2';
    } else {
        DISPLAY_INFO_IMAGE.totalImagePage.firstElementChild.innerHTML = `${DISPLAY_INFO_IMAGE.imageList}`;
    }
}

function MovePrevAndNext(e, ul) { //버튼을 누르면 이미지가 앞뒤로 이동
    const title = e.currentTarget.getAttribute('title');
    ul.style.transition = '1s';
    if (title === '다음') {
        // if (DISPLAY_INFO_IMAGE.imagePageIndex == 1) {
        //     return;
        // }
        ++DISPLAY_INFO_IMAGE.imagePageIndex;
        ul.style.transform = `translateX(-${DISPLAY_INFO_IMAGE.imagePageIndex * 100}%)`;
    } else if (title === '이전') {
        // if (DISPLAY_INFO_IMAGE.imagePageIndex == 0) {
        //     return;
        // }
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

    if (DISPLAY_INFO_IMAGE.imagePageIndex + 1 == 1) {
        DISPLAY_INFO_IMAGE.prevBtn.firstElementChild.classList.add('off');
    } else if (DISPLAY_INFO_IMAGE.imagePageIndex + 1 == 2) {
        DISPLAY_INFO_IMAGE.prevBtn.firstElementChild.classList.remove('off');
    }

    putImagePage();
}