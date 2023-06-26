package com.example.todolist.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class TodoListVO {
    private Long todo_id;
    private String content;
    private Date regdate;
    private Date updatedate;
    private Boolean is_completed;
    private MemberVO member;  // MemberVO 참조 필드
    private String member_login_id;

}

/* SQL 문
CREATE TABLE member (
    login_id VARCHAR(20) PRIMARY KEY,
    login_passwd VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE todolist (
    todo_id BIGINT PRIMARY KEY,
    content VARCHAR(2000) NOT NULL,
    regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updatedate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_completed BOOLEAN DEFAULT FALSE,
    member_login_id VARCHAR(20),
    FOREIGN KEY (member_login_id) REFERENCES member(login_id)
);

CREATE SEQUENCE SEQ_TODO_ID START WITH 1 INCREMENT BY 1;

 */