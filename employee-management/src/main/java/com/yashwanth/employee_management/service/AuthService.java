package com.yashwanth.employee_management.service;

import com.yashwanth.employee_management.model.User;
import com.yashwanth.employee_management.repository.UserRepository;
import com.yashwanth.employee_management.security.AuthRequest;
import com.yashwanth.employee_management.security.AuthResponse;
import com.yashwanth.employee_management.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(AuthRequest request){
        User user = new User();
        user.setUserName(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return "User registered successfully ";
    }


    public AuthResponse login(AuthRequest request){
        User user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User Not found") );

        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        String token = jwtUtil.generateToken(user.getUserName());
        return new AuthResponse(token);
    }





}
