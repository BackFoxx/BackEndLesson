package com.example.mythymeleaf2.service;

import com.example.mythymeleaf2.model.Board;
import com.example.mythymeleaf2.model.User;
import com.example.mythymeleaf2.repository.BoardRepository;
import com.example.mythymeleaf2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public Board save(String username, Board board) {
        User user = userRepository.findByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }
}
