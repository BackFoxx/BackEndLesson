package com.example.springrealsecurity.service.Impl;

import com.example.springrealsecurity.domain.Account;
import com.example.springrealsecurity.repository.UserRepository;
import com.example.springrealsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(Account account) {
        userRepository.save(account);
    }
}
