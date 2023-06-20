package com.example.todolist.service;

import com.example.todolist.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberServiceTest {
    @Autowired
    private MemberService service;


    // 모든 회원정보를 조회
    @Test
    public void testGet() {
        List<MemberVO> list = service.getList();

        for (MemberVO item : list)
            log.info("item = {}", item);
    }

    //READ
    @Test
    public void testRead() {
        log.info("read = {}", service.read("a"));
    }

    // Update
    @Test
    public void testUpdate() {
        MemberVO member = service.read("a");

        member.setLogin_passwd("testServiceUpdate");

        log.info("MemberService.update() = {}", service.update(member));
    }

    // DELETE
    @Test
    public void testDelete() {
        log.info("service.delete() = {}", service.delete("a"));

    }


}