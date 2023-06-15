package com.example.todolist.mapper;

import com.example.todolist.domain.MemberVO;
import com.example.todolist.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
@Slf4j
class MemberMapperTest {
    @Autowired
    private MemberMapper mapper;

    @Test
    public void testInsertMember() {
        MemberVO member = new MemberVO();
        member.setLogin_id("login123");
        member.setLogin_passwd("password123");
        member.setName("John Doe");

        mapper.insertMember(member);
    }

    @Test
    public void testSelectMemberById() {
        String loginId = "login123";

        MemberVO member = mapper.selectMemberById(loginId);
        System.out.println(member);
    }
}