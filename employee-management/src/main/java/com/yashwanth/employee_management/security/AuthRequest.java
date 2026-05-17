package com.yashwanth.employee_management.security;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}