package com.example.todolist.controller;

import com.example.todolist.domain.MemberVO;
import com.example.todolist.domain.TodoListVO;
import com.example.todolist.service.MemberService;
import com.example.todolist.service.TodoListService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/showWritePage")
    public String showWritePage() {
        return "/todolist/write";
    }

    @PostMapping("/write")
    public String write(HttpServletRequest request, TodoListVO todoListVO, RedirectAttributes redirectAttributes) {
        // 세션객체를 생성해서
        // 변수에 아이디값을 저장
        HttpSession session = request.getSession();
        String login_id = (String) session.getAttribute("login_id");

        // 저장한 아이디값을 이용해 MemberVO 객체 생성
        MemberVO member = new MemberVO();
        member.setLogin_id(login_id);

        // TodoListVO에 MemberVO 객체를 설정
        todoListVO.setMember(member);
        todoListService.register(todoListVO);

        log.info("write = {}", todoListVO);

        return "/todolist/read";
    }

    /*
    @GetMapping("/read")
    public TodoListVO read(@RequestParam Long id) {
        log.info("Service.read(id) = {}", id);
        return todoListService.get(id);
    }
    */

    @GetMapping("/read")
    public String read(@RequestParam Long id, Model model) {
        TodoListVO todoListVO = todoListService.get(id);
        model.addAttribute("todolistVO", todoListVO);
        log.info("Service.read(id) = {}", id);
        return "/todolist/read";
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id, TodoListVO todoListVO, RedirectAttributes redirectAttributes) {
        todoListService.update(todoListVO);

        log.info("Controller#Update");

        return "redirect:/todolist/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        todoListService.delete(id);

        log.info("Service.delete(id) = {}", id);

        return "redirect:/todolist/list";
    }

    // 로그인 성공이후 회원이 자신의 비밀번호를 수정하는 메서드
    @PostMapping("/update_passwd")
    public String update_passwd(MemberVO memberVO) {

        memberService.update(memberVO);


        return "redirect:/todolist/list";
    }

}
