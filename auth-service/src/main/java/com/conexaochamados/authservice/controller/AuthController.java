package com.conexaochamados.authservice.controller;

import com.conexaochamados.authservice.dto.LoginRequest;
import com.conexaochamados.authservice.dto.LoginResponse;
import com.conexaochamados.authservice.dto.RegisterRequest;
import com.conexaochamados.authservice.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
                return service.login(request);
    }

    @PostMapping("/register")
    public LoginResponse register(@Valid @RequestBody RegisterRequest request){
        return service.register(request);
    }
}
