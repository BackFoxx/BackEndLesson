package com.example.vueBackEnd.repository;

import com.example.vueBackEnd.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
