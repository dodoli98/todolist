package com.example.todolist.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class LoginMapperTest {
    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void testCheckCredentials() {
        // 테스트할 데이터
        String loginId = "abc123";
        String loginPasswd = "abc123";

        // 테스트 실행
        boolean result = loginMapper.checkCredentials(loginId, loginPasswd);

        // 결과 확인
        assertTrue(result);
    }
}
