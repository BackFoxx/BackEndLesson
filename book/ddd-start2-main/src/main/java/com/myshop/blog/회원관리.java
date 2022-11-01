package com.myshop.blog;

import com.myshop.board.domain.Article;
import com.myshop.board.domain.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class 회원관리 {
    public void blockMember(회원 회원) {
        if (회원.getState().equals("vip")) {
            throw new IllegalArgumentException("vip는 차단할 수 없습니다.");
        }
        if (회원.getName().equals("백여우")) {
            throw new IllegalArgumentException("귀여운 사람의 정보는 변경할 수 없습니다.");
        }
        회원.setState("blocked");
    }

    public void updateMemberToVip(회원 회원) {
        if (회원.getState().equals("blocked")) {
            throw new IllegalArgumentException("차단된 사용자는 vip가 될 수 없습니다.");
        }
        if (회원.getName().equals("백여우")) {
            throw new IllegalArgumentException("귀여운 사람의 정보는 변경할 수 없습니다.");
        }
        회원.setState("vip");
    }
}
