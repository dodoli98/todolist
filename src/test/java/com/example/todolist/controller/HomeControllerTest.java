package com.example.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class HomeControllerTest {
    @Autowired
    MockMvc mockMvc;

    // 홈화면 연결 확인
    @Test
    public void testHome() throws Exception{
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())         // 응답 상태 코드 검증
                .andDo(print());
    }

    // 회원가입 테스트
    @Test
    public void testRegister() throws Exception{
        // GET 방식의 요청 생성
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/register")
                .param("login_id", "controller")
                .param("login_passwd", "passwd")
                .param("name", "JUnit");

        // 요청을 수행하고, 요청과 응답 결과 확인
        mockMvc.perform(builder)
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }

    // 로그인 테스트
    // 로그인 후 리스트화면 출력, 세션객체에 아이디값을 저장
    @Test
    public void testLogin() throws Exception{
        // POST 방식의 요청
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/login")
                .param("login_id", "222")
                .param("login_passwd", "222");

        mockMvc.perform(builder)
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }

    // 로그아웃 테스트
    @Test
    public void testLogout() throws Exception {
        // POST 방식의 요청
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/logout");

        mockMvc.perform(builder)
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }

}