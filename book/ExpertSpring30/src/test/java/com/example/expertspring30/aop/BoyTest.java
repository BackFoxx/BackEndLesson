package com.example.expertspring30.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.support.XmlWebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration("Config.xml")
class BoyTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void test() {
        Person person = applicationContext.getBean(Person.class);
        person.runSomething();
    }
}