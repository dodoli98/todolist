package com.example.todolist.mapper;

import com.example.todolist.domain.TodoListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoListMapper {
    // TodoList 의 모든 레코드를 조회
    List<TodoListVO> getList(String memberLoginId);

    // Create
    void insertSelectKey(TodoListVO board);

    // Read
    TodoListVO read(Long id);

    // Update → 반환 값이 int 인 경우 수정한 레코드의 개수가 반환됨.
    int update(TodoListVO board);

    // Delete → 반환 값이 int 인 경우 삭제한 레코드의 개수가 반환됨.
    int delete(Long id);

    // deleteByMemberLoginId → 회원정보를 삭제하기 이전에 회원이 작성한 모든 레코드를 삭제
    int deleteByMemberLoginId(String memberLoginId);
}
