var data = [
	{"id" : 88, "name" : "crong", "content" : "새로운글을 올렸어요", "like" : 5, "comment" : ["댓글이다", "잘했어요"]},
	{"id" : 28, "name" : "hary", "content" : "전 오늘도 노래를 불렀어요", "like" : 0, "comment" : ["제발고만..","듣고싶네요 그노래"]},
	{"id" : 23, "name" : "pororo", "content" : "크롱이 항상 말썽을 피워서 행복해~", "like" : 4, "comment" : []},
	{"id" : 5, "name" : "pobi", "content" : "물고기를 한마리도 잡지 못하다니..", "like" : 5, "comment" : ["댓글이다", "멋진글이네요", "잘봤습니다"]}
];

var template = document.querySelector("#listTemplate").innerText;
var bindTemplate = Handlebars.compile(template);
const div = document.querySelector('.stunk');




Handlebars.registerHelper("likes", function (like) {
     if (like > 4) {
         return "<span>축하해요 좋아요가 " + like + "개 이상입니다!</span>";
     } else if (like < 1) {
         return "아직 아무도 좋아하지 않아요..";
     } else {
         return like + "개의 좋아요가 있네요";
     }
 });

 data.forEach((data) => {
   div.innerHTML += bindTemplate(data);
});
