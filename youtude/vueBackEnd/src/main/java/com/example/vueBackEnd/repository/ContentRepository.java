package com.example.vueBackEnd.repository;

import com.example.vueBackEnd.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {
}
