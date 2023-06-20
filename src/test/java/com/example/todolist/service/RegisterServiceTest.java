package com.example.todolist.service;

import com.example.todolist.domain.MemberVO;
import com.example.todolist.mapper.RegisterMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class RegisterServiceTest {
    @Autowired
    private RegisterService service;

    @Test
    public void testRegister() {
        MemberVO member = new MemberVO();

        member.setLogin_id("RegisterServiceTest");
        member.setLogin_passwd("RegisterServiceTest");
        member.setName("스타벅");

        service.register(member);

        log.info("registered member = {}", member);
    }
}