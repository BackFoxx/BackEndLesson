document.addEventListener('DOMContentLoaded', function () { //DomContent 로딩 완료 후 실행
    getPromotionList();
});

function getPromotionList() {
    var http = new XMLHttpRequest();
    http.responseType = 'json';
    http.open('GET', '/api/promotions');
    http.onreadystatechange = function (e) {
        if (http.readyState === 4 && http.status === 200) {
            showPromotionImages(http.response['items'])
        }
    };
    http.send();
} // 프로모션 리스트 가져오기

function showPromotionImages(items) {
    const imageUl = document.querySelector('.visual_img');
    const imageLi = '<li>' +
        '<a><img src="{product_image_url}"></a>' +
        '</li>'
    const length = items.length;
    for (var i = 0; i < length; i++) {
        const resultContent = imageLi.replace('{product_image_url}', items[i].product_image_url);
        imageUl.innerHTML += resultContent;
    }
}