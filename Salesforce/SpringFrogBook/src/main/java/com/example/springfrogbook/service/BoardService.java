package com.example.springfrogbook.service;

import com.example.springfrogbook.domain.BoardVO;

import java.util.List;

public interface BoardService {
    public abstract List<BoardVO> list();

    public abstract int delete(BoardVO boardVO);

    public abstract int edit(BoardVO boardVO);

    public abstract void write(BoardVO boardVO);

    public abstract BoardVO read(int seq);
}
