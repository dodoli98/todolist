package com.example.todolist.mapper;

import com.example.todolist.domain.TodoListVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class TodoListMapperTest {
    // TodoListMapper 주입
    @Autowired
    private TodoListMapper mapper;

    @Test
    public void testGetList() {
        List<TodoListVO> list = mapper.getList("loginId");

        for (TodoListVO item : list)
            log.info("item = {}", item);
    }

    @Test
    public void insertSelectKey() {
        TodoListVO todolist = new TodoListVO();

        todolist.setContent("3번째");

        mapper.insertSelectKey(todolist);

        log.info("TodoList = {}", todolist);
    }

    @Test
    public void read() {
        log.info("read = {}", mapper.read(2L));
    }

    @Test
    public void update() {
        TodoListVO todoList = new TodoListVO();

        todoList.setTodo_id(2L);

        todoList.setContent("업데이트");

        log.info("Updated record = {}", mapper.update(todoList));
    }

    @Test
    public void delete() {
        log.info("deleted record = {}", mapper.delete(2L));
    }
}