package com.myshop.blog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Blog2 {
    private Long id;
    private String title;
    private String content;
    private 회원 Writer;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(회원 writer) {
        Writer = writer;
    }
}
