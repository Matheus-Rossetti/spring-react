package com.conexaochamados.authservice.service;

import com.conexaochamados.authservice.dto.LoginRequest;
import com.conexaochamados.authservice.dto.LoginResponse;
import com.conexaochamados.authservice.dto.RegisterRequest;
import com.conexaochamados.authservice.model.TechnicianModel;
import com.conexaochamados.authservice.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final TechnicianRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request){
        TechnicianModel technician = repository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Email inválido"));

        if (!passwordEncoder.matches(request.password(), technician.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.generateToken(technician.getEmail());

        return new LoginResponse(token, technician.getId(), technician.getName());
    }

    public LoginResponse register(RegisterRequest request){
        String hashedPassword = passwordEncoder.encode(request.password());

        TechnicianModel technician = new TechnicianModel();
        technician.setName(request.name());
        technician.setEmail(request.email());
        technician.setPassword(hashedPassword);

        repository.save(technician);

        return login( new LoginRequest(request.email(), request.password()));
    }
}
