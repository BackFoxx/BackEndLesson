document.addEventListener('DOMContentLoaded', function (e) {
    getProductAndCount(0, 0);
})

var watchingCategory = 0;

//카테고리 버튼

const categoryBtn = document.querySelector('.event_tab_lst');
categoryBtn.addEventListener('click', function (e) {
    selectCategory(e);
});

function selectCategory (e) {
    const dataCategory = e.target.closest('li').getAttribute('data-category');
    console.log(dataCategory);
    getProductAndCount(dataCategory, 0)
}

//리스트 가져오기
function getProductAndCount(categoryId, start) {
    var http = new XMLHttpRequest();
    http.responseType = 'json';
    http.onreadystatechange = function (ev) {
        if (http.readyState === 4 && http.status === 200) {
            const response = http.response;
            setTotalCount(response['totalCount']);
            setProductList(response['items'], categoryId);
        }
    };

    http.open("GET", "/api/products?categoryId=" + categoryId + "&start=" + start);
    http.send()
}

function setTotalCount(totalCount) {
    var text = document.querySelector(".event_lst_txt .pink");
    text.innerHTML = totalCount+'개';
}

function setProductList(items, categoryId) {
    const boxes = document.querySelectorAll(".lst_event_box");
    const length = items.length;
    var number = 0; //lst_event_box 2개를 왔다갔다 하며 리스트가 생성되도록

    if (watchingCategory !== categoryId) {
        for (var i = 0; i < boxes.length; i++) {
            boxes[i].innerHTML = '';
        }
    }

    for (var i = 0; i < length; ++i) {
        boxes[number].innerHTML +=
            '<li class="item">\n' +
            '    <a href="detail.html" class="item_book">\n' +
            '        <div class="item_preview"> <img alt="' + items[i].product_description + '" class="img_thumb" src="' + items[i].product_image_url + '"><span class="img_border"></span> </div>\n' +
            '        <div class="event_txt">\n' +
            '            <h4 class="event_txt_tit"> <span>' + items[i].product_description + '</span> <small class="sm">' + items[i].place_name + '</small> </h4>\n' +
            '            <p class="event_txt_dsc">' + items[i].product_content +'</p>\n' +
            '        </div>\n' +
            '    </a>\n' +
            '</li>';
        if (number === 0) {
            number = 1;
        }
        else if (number === 1) {
            number = 0;
        }

    }

    watchingCategory = categoryId;
}