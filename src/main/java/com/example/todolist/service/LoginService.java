package com.example.todolist.service;

public interface LoginService {

    /**
     *
     * @param loginId
     * @param password
     * @return          입력한 id와 password 가 일치하는지 여부
     */
    boolean login(String loginId, String password);
}
