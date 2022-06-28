package com.example.demo.비지터패턴;

public interface Visitor {
    void visit(Book book);

    void visit(Album album);

    void visit(Movie movie);
}
