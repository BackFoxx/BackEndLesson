document.addEventListener('DOMContentLoaded', () => {
    getDisplayInfoAjax();
});

const AJAX = {
    displayInfoAjax: null
}

function getDisplayInfoAjax() {
    const http = new XMLHttpRequest();
    const displayInfoId = new URL(document.URL).searchParams.get("id");

    http.responseType = 'json';
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            AJAX.displayInfoAjax = http.response;

            GetAjaxToProductImageJs();
            GetAjaxToProductDescriptionJs();
        }
    };

    http.open('GET', `/api/products/${displayInfoId}`);
    http.send();
};