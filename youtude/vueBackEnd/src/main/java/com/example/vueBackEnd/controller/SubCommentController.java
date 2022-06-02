package com.example.vueBackEnd.controller;

import com.example.vueBackEnd.entity.SubComment;
import com.example.vueBackEnd.repository.SubCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SubCommentController {
    private final SubCommentRepository subCommentRepository;

    @PostMapping("/add/sub_comment")
    public SubComment addSubComment(@RequestBody Map<String, Object> map) {
        int userId = (int) map.get("user_id");
        int commentId = (int) map.get("comment_id");
        String context = (String) map.get("context");

        SubComment subComment = SubComment.builder()
                .userId(userId)
                .commentId(commentId)
                .context(context).build();

        return subCommentRepository.save(subComment);
    }

    @GetMapping("/find/sub_comment")
    public List<SubComment> findSubComment(@RequestParam int comment_id) {
        return subCommentRepository.findAllByCommentId(comment_id)
                .orElseGet(() -> {
                    log.error("존재하지 않는 SubComment, commentId : {}", comment_id);
                    return null;
                });
    }
}
