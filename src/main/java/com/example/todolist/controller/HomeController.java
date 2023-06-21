package com.example.todolist.controller;

import com.example.todolist.domain.MemberVO;
import com.example.todolist.service.LoginService;
import com.example.todolist.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;


    @RequestMapping("/home")
    public String home() {
        return "home/home";
    }
}
