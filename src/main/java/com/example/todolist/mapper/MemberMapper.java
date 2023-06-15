package com.example.todolist.mapper;

import com.example.todolist.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    // 회원가입 시 회원 정보를 데이터베이스에 삽입
    void insertMember(MemberVO member);

    // 아이디를 기준으로 회원 정보를 조회
    MemberVO selectMemberById(String loginId);
}
