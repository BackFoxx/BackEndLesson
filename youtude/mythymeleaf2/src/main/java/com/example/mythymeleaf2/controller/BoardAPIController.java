package com.example.mythymeleaf2.controller;

import com.example.mythymeleaf2.model.Board;
import com.example.mythymeleaf2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardAPIController {

    private final BoardRepository repository;

    @Autowired
    public BoardAPIController(BoardRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/boards")
    public List<Board> all(@RequestParam(required = false, defaultValue = "") String title,
                           @RequestParam(required = false, defaultValue = "") String content) {
        if (StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
            return repository.findAll();
        } else {
            return repository.findByTitleOrContent(title, content);
        }
    }

    @PostMapping("/boards")
    public Board newBoard(@RequestBody Board board) {
        return repository.save(board);
    }

    @GetMapping("/boards/{id}")
    public Board one(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/boards/{id}")
    public Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {
        return repository.findById(id)
                .map(board -> {
                    board.setTitle(newBoard.getTitle());
                    board.setContent(newBoard.getContent());
                    return repository.save(board);
                })
                .orElseGet(() -> {
                    newBoard.setId(id);
                    return repository.save(newBoard);
                });
    }

    @DeleteMapping("/boards/{id}")
    public void deleteBoard(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
