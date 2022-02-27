package com.example.mythymeleaf2.repository;

import com.example.mythymeleaf2.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitle(String title);
    List<Board> findByTitleOrContent(String title, String content);

    @EntityGraph(attributePaths = "user")
    Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
