// LoginMapper.java
package com.example.todolist.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    boolean checkCredentials(String loginId, String loginPassword);
}
