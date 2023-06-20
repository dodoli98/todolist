package com.example.todolist.service;

import com.example.todolist.domain.MemberVO;

public interface RegisterService {
    /**
     * 회원가입
     * @param member 회원가입하는 회원의 정보
     */
    void register(MemberVO member);


}
