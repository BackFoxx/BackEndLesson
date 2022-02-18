function GetAjaxToProductDescriptionJs() { //DisplayInfo GET요청 보내기
    const response = AJAX.displayInfoAjax;
    PutProductContent(response.displayInfo)
}

const PRODUCT_CONTENT = {
    productContentSection: document.querySelector('.store_details'),
    productContent: document.querySelector('.dsc'),

    moreBtns: document.getElementsByClassName('bk_more'),
    moreOpenBtn: document.getElementsByClassName('bk_more _open')[0],
    moreCloseBtn: document.getElementsByClassName('bk_more _close')[0]
};

function PutProductContent(content) { //content 펼치기
    PRODUCT_CONTENT.productContent.innerHTML = content.productContent;

    Array.from(PRODUCT_CONTENT.moreBtns).forEach((e) => {
        e.addEventListener('click', function (e) {
            e.preventDefault();
            slideUpAndDown();
        });
    });
}

function slideUpAndDown() { //버튼으로 펼치기, 접기
    if (PRODUCT_CONTENT.productContentSection.classList.contains('close3')) {
        PRODUCT_CONTENT.productContentSection.classList.remove('close3');
        PRODUCT_CONTENT.moreOpenBtn.style.display = 'none';
        PRODUCT_CONTENT.moreCloseBtn.style.display = 'block';
    } else {
        PRODUCT_CONTENT.productContentSection.classList.add('close3');
        PRODUCT_CONTENT.moreOpenBtn.style.display = 'block';
        PRODUCT_CONTENT.moreCloseBtn.style.display = 'none';
    }
}
