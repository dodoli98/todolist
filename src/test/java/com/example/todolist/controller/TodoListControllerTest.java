package com.example.todolist.controller;

import com.example.todolist.domain.TodoListVO;
import com.example.todolist.service.TodoListService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class TodoListControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetList() throws Exception {
        mockMvc.perform(get("/list"))
                .andExpect(status().isOk())         // 응답 상태 코드 검증
                .andDo(print());
    }

    @Test
    public void testWrite() throws Exception {
         // 가짜 세션 생성
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("login_id", "login123");

        // 테스트할 TodoListVO 객체 생성
        TodoListVO todoListVO = new TodoListVO();
        todoListVO.setContent("Test Content");

        // POST 요청 생성
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/write")
                .session(session)
                .flashAttr("todoListVO", todoListVO);

        // 요청 실행 및 응답 검증
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(redirectedUrl("/home/read"))
                .andDo(print());
    }

    @Test
    public void testRead() throws Exception{
        // 요청을 수행하고, 요청과 응답 결과 확인
        mockMvc.perform(get("/read").param("id", "8"))
                .andExpect(redirectedUrl("/todolist/read"))             // 리다이렉트 URL 검증
                .andDo(print());                    // 요청과 응답 결과를 출력
    }
    @Test
    public void testDelete() throws Exception{
        // 요청을 수행하고, 요청과 응답 결과 확인
        mockMvc.perform(get("/delete").param("id", "8"))
                .andExpect(redirectedUrl("/todolist/list"))             // 리다이렉트 URL 검증
                .andDo(print());                    // 요청과 응답 결과를 출력
    }


}