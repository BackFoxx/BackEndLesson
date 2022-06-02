package com.example.vueBackEnd.repository;

import com.example.vueBackEnd.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Optional<List<Comment>> findAllByContentId(Integer contentId);
}
