package com.example.todolist.service;

public interface LoginService {

    /**
     *
     * @param loginId   아이디
     * @param password  패스워드
     * @return          입력한 id와 password 가 일치하는지 여부
     */
    boolean login(String loginId, String password);
}
