package com.example.demo.dao.dto;
import com.example.demo.dao.domain.Comment;
import com.example.demo.security.user.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
