package com.example.vueBackEnd.controller;

import com.example.vueBackEnd.entity.Users;
import com.example.vueBackEnd.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@RestController
public class UsersController {
    private final UsersRepository usersRepository;

    @PostMapping("/add/user")
    public Users addUser(@RequestBody Map<String, Object> userMap) {
        String userName = (String) userMap.get("user_name");
        Users users = Users.builder()
                .name(userName).build();
        return usersRepository.save(users);
    }

    @GetMapping("/find/user")
    public Users findUsers(@RequestParam int user_id) {
        Optional<Users> findUser = usersRepository.findById(user_id);
        if (findUser.isEmpty()) {
            log.error("유저를 찾을 수 없음, userId : {}", user_id);
            return null;
        }
        return findUser.get();
    }
}
