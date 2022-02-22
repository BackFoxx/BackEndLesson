function GetAjaxToProductDescriptionJs() { //DisplayInfo GET요청 보내기
    const response = AJAX.displayInfoAjax;
    PutProductContent(response.displayInfo)
}

const PRODUCT_DESCRIPTION = {
    productContentSection: document.querySelector('.store_details'),
    productContent: document.querySelector('.dsc'),

    moreBtns: document.getElementsByClassName('bk_more'),
    moreOpenBtn: document.getElementsByClassName('bk_more _open')[0],
    moreCloseBtn: document.getElementsByClassName('bk_more _close')[0]
};

function PutProductContent(content) { //content 펼치기
    PRODUCT_DESCRIPTION.productContent.innerHTML = content.productContent;

    Array.from(PRODUCT_DESCRIPTION.moreBtns).forEach((e) => {
        e.addEventListener('click', function (e) {
            e.preventDefault();
            slideUpAndDown();
        });
    });
}

function slideUpAndDown() { //버튼으로 펼치기, 접기
    if (PRODUCT_DESCRIPTION.productContentSection.classList.contains('close3')) {
        PRODUCT_DESCRIPTION.productContentSection.classList.remove('close3');
        PRODUCT_DESCRIPTION.moreOpenBtn.style.display = 'none';
        PRODUCT_DESCRIPTION.moreCloseBtn.style.display = 'block';
    } else {
        PRODUCT_DESCRIPTION.productContentSection.classList.add('close3');
        PRODUCT_DESCRIPTION.moreOpenBtn.style.display = 'block';
        PRODUCT_DESCRIPTION.moreCloseBtn.style.display = 'none';
    }
}
