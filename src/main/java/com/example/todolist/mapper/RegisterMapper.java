package com.example.todolist.mapper;

import com.example.todolist.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    // 회원가입 시 회원 정보를 데이터베이스에 삽입
    void insertMember(MemberVO member);
}


