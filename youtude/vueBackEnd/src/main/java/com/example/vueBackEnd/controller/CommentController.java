package com.example.vueBackEnd.controller;

import com.example.vueBackEnd.entity.Comment;
import com.example.vueBackEnd.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    @PostMapping("/add/comment")
    public Comment addComment(@RequestBody Map<String, Object> map) {
        int userId = (int) map.get("user_id");
        int contentId = (int) map.get("content_id");
        String context = (String) map.get("context");

        Comment comment = Comment.builder()
                .userId(userId)
                .contentId(contentId)
                .context(context).build();

        return commentRepository.save(comment);
    }

    @GetMapping("/find/comment")
    public List<Comment> findComment(@RequestParam int content_id) {
        Optional<List<Comment>> findComments = commentRepository.findAllByContentId(content_id);
        return findComments.orElseGet(() -> {
            log.error("존재하지 않는 Comment, CommentId : {}", content_id);
            return null;
        });
    }
}
