package com.example.mythymeleaf2.controller;

import com.example.mythymeleaf2.model.Board;
import com.example.mythymeleaf2.model.QUser;
import com.example.mythymeleaf2.model.User;
import com.example.mythymeleaf2.repository.CustomizedUserRepository;
import com.example.mythymeleaf2.repository.CustomizedUserRepositoryImpl;
import com.example.mythymeleaf2.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class UserAPIController {

    private final UserRepository userRepository;
    private final CustomizedUserRepository customizedUserRepository;

    @GetMapping("/users")
    public Iterable<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text) {
        List<User> users = null;
        if ("query".equals(method)) {
            users = userRepository.findByUsernameQuery(text);
        } else if ("querydsl".equals(method)) {
            QUser user = QUser.user;
            Predicate query = user.username.contains(text);
            return userRepository.findAll(query);
        } else if ("querydslcustom".equals(method)) {
            users = customizedUserRepository.findByCustomUsername(text);
        } else  {
            users = userRepository.findAll();
        }
        return users;
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User one(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/users/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.getBoards().clear();
                    user.getBoards().addAll(newUser.getBoards());
                    for (Board board : user.getBoards()) {
                        board.setUser(user);
                    }
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
