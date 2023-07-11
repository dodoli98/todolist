package com.example.todolist.service;

import com.example.todolist.domain.MemberVO;
import com.example.todolist.domain.TodoListVO;
import com.example.todolist.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    // 매퍼주입
    private MemberMapper mapper;


    @Override
    public MemberVO read(String login_id) {
        log.info("Read");

        return mapper.read(login_id);
    }

    @Override
    public boolean update(MemberVO member) {
        log.info("update member = {}", member);

        return mapper.update(member) == 1;
    }

    @Override
    public boolean delete(String login_id) {
        log.info("deleted member id = {}", login_id);

        return mapper.delete(login_id) == 1;
    }

    @Override
    public List<MemberVO> getList() {
        log.info("getList");

        return mapper.getList();
    }
}
