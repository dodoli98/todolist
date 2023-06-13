package com.example.todolist.domain;

import lombok.Data;

@Data
public class MemberVO {
    private String login_id;
    private String login_passwd;
    private String name;
}
