package com.example.expertspring30.aop;

import org.springframework.stereotype.Component;

//@Component
public class Boy implements Person {
    public void runSomething() {
        System.out.println("컴퓨터 게임");
    }
}
