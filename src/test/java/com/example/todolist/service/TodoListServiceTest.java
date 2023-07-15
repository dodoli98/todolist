package com.example.todolist.service;

import com.example.todolist.domain.TodoListVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TodoListServiceTest {
    @Autowired
    private TodoListService todoListService;


    @Test
    public void testGetList() {
        List<TodoListVO> list = todoListService.getList("login123");

        for (TodoListVO item : list)
            log.info("item = {}", item);
    }

    @Test
    public void testRegister() {
        TodoListVO todoListVO = new TodoListVO();

        todoListVO.setContent("3. Service.Register() Test");

        todoListService.register(todoListVO);

        log.info("registered id = {}", todoListVO.getTodo_id());
    }

    @Test
    public void testGet() {
        log.info("todoListService.get()= {}", todoListService.get(9L));
    }

    @Test
    public void testUpdate() {
        // 수정할 레코드를 불러옴
        TodoListVO todoListVO = todoListService.get(3L);

        // 해당 레코드가 없으면 메서드 종료
        if (todoListVO == null) return;

        todoListVO.setContent("Service.update Test");


        log.info("todoListService.update()= {}", todoListService.update(todoListVO));

    }

    @Test
    public void testDelete() {
        log.info("todoListService.delete()= {}", todoListService.delete(4L));
    }
}