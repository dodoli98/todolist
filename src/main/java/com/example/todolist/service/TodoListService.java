package com.example.todolist.service;

import com.example.todolist.domain.TodoListVO;

import java.util.List;

public interface TodoListService {

    /**
     * CREATE: 게시물을 등록
     *
     * @param board 등록할 게시물의 정보
     */
    void register(TodoListVO board);

    /**
     * READ: 게시물을 조회
     *
     * @param id 조회할 게시물의 id
     * @return 조회한 게시물의 정보
     */
    TodoListVO get(Long id);

    /**
     * UPDATE: 게시물을 수정
     *
     * @param board 수정할 게시물의 정보
     * @return 정상적으로 게시물을 수정했는지 여부
     */
    boolean update(TodoListVO board);

    /**
     * DELETE: 게시물을 삭제
     *
     * @param id 삭제할 게시물의 id
     * @return 정상적으로 게시물을 삭제했는지 여부 (True/False)
     */
    boolean delete(Long id);

    /**
     * 게시물 목록을 조회
     *
     * @return TodoListVO 객체들을 담고 있는 List 객체
     */
    List<TodoListVO> getList();
}
