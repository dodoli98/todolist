package com.example.todolist.service;

import com.example.todolist.domain.TodoListVO;
import com.example.todolist.mapper.TodoListMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TodoListServiceImpl implements TodoListService {

    // @Autowired
    // 생성자가 하나이면 @Autowired 주해를 생략해도 스프링 컨테이너가 빈(bean)을 주입한다.
    private TodoListMapper mapper;

    @Override
    public void register(TodoListVO board) {
        // 외래키 값 설정
        // 외래키 값 설정
        String memberLoginId = board.getMember().getLogin_id();
        board.setMember_login_id(memberLoginId);

        log.info("register = {}", board);
        mapper.insertSelectKey(board);
    }

    @Override
    public TodoListVO get(Long id) {
        log.info("get = {}", id);

        return mapper.read(id);
    }

    @Override
    public boolean update(TodoListVO board) {
        log.info("update = {}", board);

        // mapper 에서 update() 의 반환값은 메서드가 실행되 실행결과가 반영된 레코드의 개수가 반환된다.
        // 즉 mapper.update(board)가 정상실행된다면 1을 반환하게 될것이다.
        return mapper.update(board) == 1;
    }

    @Override
    public boolean delete(Long id) {
        log.info("delete = {}", id);

        return mapper.delete(id) == 1;
    }

    @Override
    public List<TodoListVO> getList(String memberLoginId) {
        log.info("getList");

        return mapper.getList(memberLoginId);
    }

    @Override
    public boolean deleteByMemberLoginId(String memberLoginId) {
        log.info("Delete List where = {}", memberLoginId);

        return mapper.deleteByMemberLoginId(memberLoginId) == 1;
    }

}
