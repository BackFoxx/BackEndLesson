function GetAjaxToProductContentJs() {
    const displayInfo = AJAX.displayInfoAjax;
    PRODUCT_CONTENT.detailBtns.addEventListener('click', (e) => {
        selectContentBtn(e);
    });

    putDetailArea(displayInfo.displayInfo);
    putDetailLocation(displayInfo.displayInfo, displayInfo.displayInfoImage.saveFileName);
}

const PRODUCT_CONTENT = {
    detailAreaBtn: document.querySelector('.item._detail'),
    detailLocationBtn: document.querySelector('.item._path'),
    detailBtns: document.querySelector('.info_tab_lst'),

    detailAreaTemplate: document.querySelector('#detailArea'),
    detailLocationTemplate: document.querySelector('#detailLocation'),
    detailArea: document.querySelector('.detail_area_wrap'),
    detailLocation: document.querySelector('.detail_location')
};

function selectContentBtn(e) {
    e.preventDefault();

    if (e.target.closest('li') === PRODUCT_CONTENT.detailAreaBtn) {
        PRODUCT_CONTENT.detailAreaBtn.firstElementChild.classList.add('active');
        PRODUCT_CONTENT.detailLocationBtn.firstElementChild.classList.remove('active');

        PRODUCT_CONTENT.detailArea.classList.remove('hide');
        PRODUCT_CONTENT.detailLocation.classList.add('hide');
    } else {
        PRODUCT_CONTENT.detailAreaBtn.firstElementChild.classList.remove('active');
        PRODUCT_CONTENT.detailLocationBtn.firstElementChild.classList.add('active');

        PRODUCT_CONTENT.detailArea.classList.add('hide');
        PRODUCT_CONTENT.detailLocation.classList.remove('hide');
    }
}

function putDetailArea(displayInfo) {
    const obj = {
        content: displayInfo.productContent
    };

    const bindTemplate = Handlebars.compile(PRODUCT_CONTENT.detailAreaTemplate.innerHTML);
    PRODUCT_CONTENT.detailArea.innerHTML = bindTemplate(obj);
}

function putDetailLocation(displayInfo, displayInfoImage) {
    const obj = {
        productDescription: displayInfo.productDescription,
        placeLot: displayInfo.placeLot,
        placeStreet: displayInfo.placeStreet,
        telephone: displayInfo.telephone,
        placeName: displayInfo.placeName,
        MapImage: displayInfoImage
    }

    const bindTemplate = Handlebars.compile(PRODUCT_CONTENT.detailLocationTemplate.innerHTML);
    PRODUCT_CONTENT.detailLocation.innerHTML = bindTemplate(obj);
}