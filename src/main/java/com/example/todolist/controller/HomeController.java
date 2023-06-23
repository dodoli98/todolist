package com.example.todolist.controller;

import com.example.todolist.domain.MemberVO;
import com.example.todolist.service.LoginService;
import com.example.todolist.service.RegisterService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    @GetMapping("/home")
    public String home() {
        return "home/home";
    }

    @GetMapping("/register")
    public String register(MemberVO member, RedirectAttributes redirectAttributes) {

        registerService.register(member);

        return "redirect:/home/home";
    }

    // 로그인에 성공한경우 세션 객체에 아이디 정보를 저장한다.
    // 그 다음 리스트를 출력하거나 리스트관련 로직을 처리할 때 계속 세션에 있는 아이디 정보를 사용
    // 그 후 로그아웃 메서드가 호출되면 세션을 해제해 주도록한다.
    @PostMapping("/login")
    public String login(HttpServletRequest request, String login_id, String login_passwd) {

        if (loginService.login(login_id, login_passwd)){
            request.getSession().setAttribute("login_id", login_id);
            return "redirect:/home/todolist";
        } else
            return "redirect:/home/home";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("login_id");
        return "redirect:/home";
    }
}
