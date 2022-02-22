document.addEventListener('DOMContentLoaded', () => {
    getDisplayInfoAjax();
});

const AJAX = {
    displayInfoId: new URL(document.URL).searchParams.get("id"),
    displayInfoAjax: null
}

function getDisplayInfoAjax() {
    const http = new XMLHttpRequest();

    http.responseType = 'json';
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            AJAX.displayInfoAjax = http.response;

            GetAjaxToProductImageJs();
            GetAjaxToProductDescriptionJs();
            GetAjaxToShortReviewJs();
            GetAjaxToProductContentJs();
        }
    };

    http.open('GET', `/api/products/${AJAX.displayInfoId}`);
    http.send();
};