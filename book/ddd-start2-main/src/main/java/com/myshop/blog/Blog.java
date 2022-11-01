package com.myshop.blog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Blog {
    private Long id;
    private String title;
    private String content;
    private 회원 Writer;

    public void changeTitle(String newTitle) {
        checkTitle(newTitle); // title의 형식이 올바른지 검증합니다.
        this.title = newTitle;
    }

    private void checkTitle(String title) {
        Pattern titlePattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{10,}$");
        Matcher matcher = titlePattern.matcher(title);

        if (!matcher.find()) {
            throw new IllegalArgumentException("title의 작성 양식이 틀리다.");
        }
    }

    public void changeContent(String newContent) {
        askPresident(newContent); // 대통령의 허락을 구합니다
        this.content = newContent;
    }

    private void askPresident(String newContent) {
        if (!JoeBiden.isContentAcceptable(newContent)) {
            throw new IllegalArgumentException("대통령이 거부하셨다.");
        }
    }
}
