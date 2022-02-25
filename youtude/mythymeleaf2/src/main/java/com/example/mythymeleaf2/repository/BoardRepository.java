package com.example.mythymeleaf2.repository;

import com.example.mythymeleaf2.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
