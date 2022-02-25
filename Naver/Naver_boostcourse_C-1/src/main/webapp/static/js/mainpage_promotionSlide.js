document.addEventListener('DOMContentLoaded', function () { //DomContent 로딩 완료 후 실행
    getPromotionList();
});

/*
프로모션 리스트 가져오기
 */

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
}

function showPromotionImages(items) {
    const imageUl = document.querySelector('.visual_img');
    const content = document.querySelector('#promotionItem').innerHTML;
    const length = items.length;

    items.forEach((item) => {
        imageUl.innerHTML += content.replace('{productImageUrl}', item.productImageUrl);
    });
    imageUl.innerHTML += content.replace('{productImageUrl}', items[0].productImageUrl)

    move(length);
}

/*
슬라이드
 */

function move(length) {
    const ul = document.querySelector('.visual_img');
    var count = 0;

    setInterval(function () {
        ul.style.transition = '1s';
        ul.style.transform = "translateX(-"+ 100*(count+1) +"%)";

        count++;

        if(count === length+1){
            ul.style.transition = '0s';
            ul.style.transform = "translateX(0px)";
            count = 0;
        }

        /*
        슬라이딩 개수만큼 오른쪽으로 슬라이딩,
        슬라이딩 끝에 0번째 프로모션을 하나 더 붙인 후
        0번째 프로모션에 도달한 순간 처음으로 이동
         */
    }, 2000);
}