package com.example.todolist.service;

import com.example.todolist.domain.MemberVO;

import java.util.List;

public interface MemberService {

    /**
     * READ: id를 통해 회원정보를 조회
     *
     * @param login_id 조회할 id
     */
    MemberVO read(String login_id);

    /**
     * UPDATE: id값을 통해 회원의 비밀번호를 수정
     *
     * @param member    수정할 회원의 정보
     * @return          수정 여부
     */
    boolean update(MemberVO member);

    /**
     * DELETE: id를 통해 회원정보를삭제
     *
     * @param login_id  삭제할 회원의 id
     * @return          삭제 여부
     */
    boolean delete(String login_id);

    /**
     * 모든 회원정보를 조회
     *
     * @return 모든 레코드
     */
    List<MemberVO> getList();

}
