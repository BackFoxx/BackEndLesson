document.addEventListener('DOMContentLoaded', () => {
    const displayInfo = JSON.parse(sessionStorage.getItem('displayInfo'))
    PutAverageScore(displayInfo.averageScore);
    PutReview(displayInfo.comments, displayInfo.displayInfo.productDescription);
});

const REVIEW = {
    averageScoreStar: document.querySelector('.graph_value'),
    averageScoreNumber: document.querySelector('.text_value').firstElementChild,

    reviewCount: document.querySelector('.join_count').firstElementChild,
    ReviewTemplate: document.querySelector('#ReviewTemplate').innerHTML,
    ReviewList: document.querySelector('.list_short_review'),
}

function PutAverageScore(averageScore) {
    REVIEW.averageScoreStar.style.width = `${(averageScore * 20).toFixed(1)}%`;
    REVIEW.averageScoreNumber.innerHTML = averageScore.toFixed(1);
}

function PutReview(commentList, productDescription) {
    REVIEW.reviewCount.innerHTML = `${commentList.length}건`

    if (commentList.length > 0) {
        commentList.forEach((comment) => {
            const obj = {
                Description: productDescription,
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

            const bindTemplate = Handlebars.compile(REVIEW.ReviewTemplate);
            REVIEW.ReviewList.innerHTML += bindTemplate(obj);
        });
    }
}

