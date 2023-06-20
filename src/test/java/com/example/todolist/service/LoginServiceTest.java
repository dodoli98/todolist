package com.example.todolist.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class LoginServiceTest {
    @Autowired
    private LoginService service;

    @Test
    public void loginServiceTest() {

        log.info("login result = {}", service.login("abc123", "abc123"));


    }
}