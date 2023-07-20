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
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/showUpdatePage")
    public String showUpdatePage(@RequestParam("id") Long id, Model model, RedirectAttributes redirectAttributes) {

        TodoListVO todoListVO = todoListService.get(id);
        model.addAttribute("todoListVO", todoListVO);

        return "/todolist/update";
    }


    @GetMapping("/showUpdatePasswdPage")
    public String showUpdatePasswdPage (HttpServletRequest request, Model model) {
        String loginId = (String) request.getSession().getAttribute("login_id");
        log.info("session = {}", loginId);

        // "memberVO" 객체를 모델에 추가
        MemberVO memberVO = memberService.read(loginId);
        model.addAttribute("memberVO", memberVO);

        return "/todolist/update";
    }


    @GetMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        String loginId = (String) request.getSession().getAttribute("login_id");

        if (loginId != null) {
            List<TodoListVO> todoList = todoListService.getList(loginId);
            model.addAttribute("list", todoList);

            log.info("TodoListController#getList()");

            // "memberVO" 객체를 모델에 추가
            MemberVO memberVO = memberService.read(loginId);
            model.addAttribute("memberVO", memberVO);

            return "/todolist/list";
        } else {
            return "redirect:/home";
        }
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

        return "redirect:/list";
    }


    @GetMapping("/read")
    public String read(@RequestParam("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        TodoListVO todoListVO = todoListService.get(id);
        model.addAttribute("todolistVO", todoListVO);

        log.info("Service.read(id) = {}", id);
        return "/todolist/read";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("todoListVO") TodoListVO todoListVO, RedirectAttributes redirectAttributes) {
        todoListService.update(todoListVO);
        log.info("Controller#Update");
        redirectAttributes.addAttribute("id", todoListVO.getTodo_id());
        return "redirect:/read";
    }


    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam Long id) {
        todoListService.delete(id);

        log.info("Service.delete(id) = {}", id);

        return "todolist/list";
    }



    // 로그인 성공이후 회원의 비밀번호를 수정하는 메서드
    @PostMapping("/update_passwd")
    public String update_passwd(@ModelAttribute("memberVO") MemberVO memberVO, RedirectAttributes redirectAttributes) {
        log.info("Controller#Update_passwd");

        memberService.update(memberVO);


        return "redirect:/home";
    }

    // 회원 정보를 삭제하는 메서드
    @PostMapping("/delete_member")
    public String delete_member(HttpServletRequest request) {
        log.info("Controller#delete_member");
        String loginId = (String) request.getSession().getAttribute("login_id");

        todoListService.deleteByMemberLoginId(loginId);

        memberService.delete(loginId);

        return "redirect:/home";

    }


}
