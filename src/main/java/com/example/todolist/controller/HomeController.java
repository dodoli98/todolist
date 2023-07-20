package com.example.todolist.controller;

import com.example.todolist.domain.MemberVO;
import com.example.todolist.domain.TodoListVO;
import com.example.todolist.service.LoginService;
import com.example.todolist.service.MemberService;
import com.example.todolist.service.RegisterService;
import com.example.todolist.service.TodoListService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.logging.Logger;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private TodoListService todoListService;

    @Autowired
    private MemberService memberService;


    @GetMapping("/home")
    public String home() {
        return "home/home";
    }

    @GetMapping("/showRegisterPage")
    public String showRegisterPage() {
        return "/home/register";
    }

    @PostMapping("/register")
    public String register(MemberVO member, RedirectAttributes redirectAttributes) {

        registerService.register(member);

        return "/home/home";
    }


    @PostMapping("/login")
    public String login(HttpServletRequest request, String login_id, String login_passwd, Model model) {
        if (loginService.login(login_id, login_passwd)) {
            request.getSession().setAttribute("login_id", login_id);

            return "redirect:/list";
        } else {
            return "redirect:/home";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();

        // 로그인 ID를 세션에서 제거합니다.
        String loginId = (String) session.getAttribute("login_id");
        session.removeAttribute("login_id");

        // 세션에 로그인 ID가 있는지 확인하는 로그를 작성합니다.
        Logger logger = Logger.getLogger(getClass().getName());
        if (loginId != null) {
            logger.info("User with login ID " + loginId + " logged out.");
        } else {
            logger.info("Logout request, but user was not logged in.");
        }
        return "redirect:/home";
    }

}
