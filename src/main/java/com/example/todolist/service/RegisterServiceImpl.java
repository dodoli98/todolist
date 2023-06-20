package com.example.todolist.service;

import com.example.todolist.domain.MemberVO;
import com.example.todolist.mapper.RegisterMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    // 매퍼 주입
    private RegisterMapper mapper;


    @Override
    public void register(MemberVO member) {
        log.info("registered member = {}", member);
        mapper.insertMember(member);
    }
}
