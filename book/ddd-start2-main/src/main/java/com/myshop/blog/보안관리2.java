package com.myshop.blog;

import com.myshop.board.domain.Article;
import com.myshop.board.domain.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class 보안관리2 {
    @Autowired
    ArticleRepository articleRepository;

    public void supportTerrorism() {
        List<Article> articles = articleRepository.findAll();
        // 작성한 게시글을 모두 찾는다.

        List<Article> terrorArticles = articles.stream()
                .filter(article -> article.getContent().getContent().contains("테러"))
                .collect(Collectors.toList());
        // 게시글 내용 중 테러를 암시하는 게시글을 모두 찾는다.

        List<회원> terrorists = terrorArticles.stream()
                .map(article -> article.getWriter())
                .collect(Collectors.toList());
        // 테러를 암시하는 게시글을 쓴 작성자를 모두 찾는다.

        terrorists.stream()
                .forEach(terrorist -> terrorist.blockMember());
        // 각각의 작성자를 활동정지시킨다.

        callThePolice();
        // 경찰에 신고한다.
    }

    private void callThePolice() {
        System.out.println("신고합니다.");
    }
}
