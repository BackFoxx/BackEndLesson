function GetAjaxToShortReviewJs() {
    const response = AJAX.displayInfoAjax;
    PutAverageScore(response.averageScore);
    PutShortPreview(response.comments);

    SHORT_REVIEW.moreBtn.addEventListener('click', (e) => {
        sendDisplayInfoToReview(e, response);
    });
}

const SHORT_REVIEW = {
    averageScoreStar: document.querySelector('.graph_value'),
    averageScoreNumber: document.querySelector('.text_value').firstElementChild,

    reviewCount: document.querySelector('.join_count').firstElementChild,
    shortReviewCount: 3,
    shortReviewTemplate: document.querySelector('#ShortReviewTemplate').innerHTML,
    shortReviewList: document.querySelector('.list_short_review'),

    moreBtn: document.querySelector('.btn_review_more')
}

function PutAverageScore(averageScore) {
    SHORT_REVIEW.averageScoreStar.style.width = `${(averageScore * 20).toFixed(1)}%`;
    SHORT_REVIEW.averageScoreNumber.innerHTML = averageScore.toFixed(1);
}

function PutShortPreview(commentList) {
    SHORT_REVIEW.reviewCount.innerHTML = `${commentList.length}건`

    if (commentList.length > 0) {
        const shortCommentlist = [];
        for (var i = 0; i < SHORT_REVIEW.shortReviewCount; i++) {
            shortCommentlist.push(commentList[i]);
        }

        shortCommentlist.forEach((comment) => {
            const obj = {
                comment: comment.comment,
                score: parseFloat(comment.score).toFixed(1),
                reservationDate: function () {
                    const dateForm = comment.reservationDate.split('-');
                    const year = dateForm[0];
                    const month = dateForm[1];
                    const day = dateForm[2].split(' ')[0]
                    return `${year}.${month}.${day}`;
                },
                email: function () {
                    const email = comment.reservationEmail;
                    if (email.length > 4) {
                        return email.substr(0, 4) + '****';
                    }
                },
                image: function () {
                    if (comment.commentImage !== null) {
                        return comment.commentImage[0].saveFileName;
                    } else {
                        return false;
                    }
                },
                imageCount: function () {
                    if (comment.commentImage !== null) {
                        return comment.commentImage.length;
                    } else {
                        return false;
                    }
                },

            };

            const bindTemplate = Handlebars.compile(SHORT_REVIEW.shortReviewTemplate);
            SHORT_REVIEW.shortReviewList.innerHTML += bindTemplate(obj);
        });
    }
}

function sendDisplayInfoToReview(e, displayInfo) {
    e.preventDefault()
    sessionStorage.setItem('displayInfo', JSON.stringify(displayInfo));
    window.location.href = 'review.html';
}