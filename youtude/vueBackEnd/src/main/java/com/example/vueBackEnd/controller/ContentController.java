package com.example.vueBackEnd.controller;

import com.example.vueBackEnd.dto.FindCommentResponseDto;
import com.example.vueBackEnd.entity.Content;
import com.example.vueBackEnd.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ContentController {
    private final ContentRepository contentRepository;

    @PostMapping("/add/content")
    public Content addContent(@RequestBody Map<String, Object> map) {
        int userId = (int) map.get("user_id");
        String title = (String) map.get("title");
        String context = (String) map.get("context");
        Content content = Content.builder()
                .user_id(userId)
                .title(title)
                .context(context)
                .build();

        return contentRepository.save(content);
    }

    @PostMapping("/modify/content")
    public Content modifyContent(@RequestBody Map<String, Object> map) {
        int contextId = (int) map.get("context_id");
        String title = (String) map.get("title");
        String context = (String) map.get("context");

        Optional<Content> findContent = contentRepository.findById(contextId);
        if (findContent.isEmpty()) {
            log.error("존재하지 않는 Content, ContentId : {}", contextId);
            return null;
        }

        Content content = findContent.get();
        content.setTitle(title);
        content.setContext(context);

        return contentRepository.save(content);
    }

    @PostMapping("/delete/content")
    public Content deleteContent(@RequestBody Map<String, Object> map) {
        int contentId = (int) map.get("content_id");
        Optional<Content> findContent = contentRepository.findById(contentId);

        if (findContent.isEmpty()) {
            log.error("존재하지 않는 Content, ContentId : {}", contentId);
            return null;
        }
        contentRepository.deleteById(contentId);
        return findContent.get();
    }

    @GetMapping("/find/content")
    public Content findContent(@RequestParam int content_id) {
        Optional<Content> findContent = contentRepository.findById(content_id);
        return findContent.orElseGet(() -> {
            log.error("존재하지 않는 Content, ContentId : {}", content_id);
            return null;
        });
    }

    @GetMapping("/find/content_list")
    public List<Content> findContentList() {
        return contentRepository.findAll();
    }
}
