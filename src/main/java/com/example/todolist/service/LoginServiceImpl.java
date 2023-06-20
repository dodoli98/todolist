package com.example.todolist.service;

import com.example.todolist.mapper.LoginMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    // 매퍼주입
    private LoginMapper mapper;

    @Override
    public boolean login(String loginId, String password) {

        log.info("login_id = {}, login_passwd = {}", loginId, password);

        return mapper.checkCredentials(loginId, password);
    }
}
