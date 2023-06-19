package com.example.todolist.service;

public interface RegisterService {
    /**
     * CREATE:          회원정보를 등록
     * @param loginId   등록할 id
     * @param password  id의 비밀번호
     * @param name      회원 이름
     */
    void register(String loginId, String password, String name);

    /**
     * DELETE:          회원 정보를 삭제
     *
     * @param id        삭제할 회원의 id
     * @return          정상적으로 회원 정보를 삭제했는지 여부 (True/False)
     */
    boolean delete(Long id);}
