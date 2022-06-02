package com.example.vueBackEnd.repository;

import com.example.vueBackEnd.entity.SubComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCommentRepository extends JpaRepository<SubComment, Integer> {
    Optional<List<SubComment>> findAllByCommentId(int commentId);
}
