function GetAjaxToShortReviewJs() {
    const response = AJAX.displayInfoAjax;
    log(response);
}

const REVIEW = {
    averageScoreStar: document.querySelector('.graph_value'),
    averageScoreNumber: document.querySelector('.text_value').firstElementChild,

    reviewCount: document.querySelector('.join_count').firstElementChild,
    ReviewTemplate: document.querySelector('#ReviewTemplate').innerHTML,
    ReviewList: document.querySelector('.list_short_review'),
}

function log(response) {
    console.log(response);
}