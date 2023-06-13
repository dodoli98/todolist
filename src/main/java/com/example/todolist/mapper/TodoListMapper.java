package com.example.todolist.mapper;

import com.example.todolist.domain.TodoListVO;

import java.util.List;

public interface TodoListMapper {
    // TodoList 의 모든 레코드를 조회
    List<TodoListVO> getList();

    // Create
    void insert(TodoListVO board);

    // Create
    void insertSelectKey(TodoListVO board);

    // Read
    TodoListVO read(Long id);

    // Update → 반환 값이 int 인 경우 수정한 레코드의 개수가 반환됨.
    int update(TodoListVO board);

    // Delete → 반환 값이 int 인 경우 삭제한 레코드의 개수가 반환됨.
    int delete(Long id);
}
