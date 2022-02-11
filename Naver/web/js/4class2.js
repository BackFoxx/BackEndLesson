var data = {
  	"id" : 88,
    "name" : "crong",
    "content" : "새로운글을 올렸어요",
    "like" : 5,
    "comment" : "댓글이다"
};

var template = document.querySelector("#listTemplate").innerText;
var bindTemplate = Handlebars.compile(template);  //bindTemplate은 메서드입니다.

var resultHTML = bindTemplate(data);
