package com.example.todolist.mapper;

import com.example.todolist.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberMapperTest {
    // 매퍼 주입
    @Autowired
    private MemberMapper mapper;

    // READ
    @Test
    public void testRead() {
        MemberVO member = mapper.read("abc123");
        log.info("member = {}", member);
    }

    // UPDATE
    @Test
    public void testUpdate() {
        MemberVO member = new MemberVO();

        member.setLogin_id("a");
        member.setLogin_passwd("update passwd");

        log.info("updated record = {}", mapper.update(member));
    }

    //DELETE
    @Test
    public void testDelete() {
        log.info("Deleted record = {}", mapper.delete("c"));
    }

    // GetList
    @Test
    public void testGetList() {
        List<MemberVO> list = mapper.getList();

        for (MemberVO item : list)
            log.info("item = {}", item);
    }
}