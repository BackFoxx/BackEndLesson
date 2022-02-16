document.addEventListener('DOMContentLoaded', function () {
    getDisplayInfoAjax();
});

function getDisplayInfoAjax() {
    const displayInfoId = new URL(document.URL).searchParams.get("id");

    const http = new XMLHttpRequest();
    http.responseType = 'json';
    http.onreadystatechange = function () {
        if (http.readyState === 4 && http.status === 200) {
            const response = http.response;
            console.log(response);
        }
    };

    http.open('GET', `/api/products/${displayInfoId}`);
    http.send();
}