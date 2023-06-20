package com.example.todolist.mapper;

import com.example.todolist.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    // Read
    MemberVO read(String login_id);

    // Update → 반환 값이 int 인 경우 수정한 레코드의 개수가 반환됨.
    int update(MemberVO member);

    // Delete → 반환 값이 int 인 경우 삭제한 레코드의 개수가 반환됨.
    int delete(String login_id);

    // 모든 회원 정보를 조회
    List<MemberVO> getList();
}
