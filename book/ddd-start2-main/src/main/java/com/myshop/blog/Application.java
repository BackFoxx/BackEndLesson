package com.myshop.blog;

public class Application {
    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.changeTitle("newTitle123!@#");
        blog.changeContent("수정된 게시글 내용입니다. 이 편지는 영국으로부터···");
    }
}
