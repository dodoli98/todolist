package com.example.todolist.mapper;

import com.example.todolist.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j

class RegisterMapperTest {
    // 매퍼 주입
    @Autowired
    private RegisterMapper mapper;

    @Test
    public void insertMember() {
        MemberVO member = new MemberVO();

        member.setLogin_id("c");
        member.setLogin_passwd("123");
        member.setName("Mr.Lee");

        mapper.insertMember(member);

        log.info("member = {}", member);
    }

}