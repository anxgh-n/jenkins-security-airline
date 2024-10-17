package com.example.Security.Service;

import com.example.Security.Entity.Security;
import com.example.Security.Repository.SecurityRepo;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    JwtService jwtService;
    @Autowired
    private SecurityRepo securityRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Security register(Security security){
        security.setPassword(passwordEncoder.encode(security.getPassword()));
        return securityRepo.saveAndFlush(security);
    }

    public boolean verifyToken(String token) {
        jwtService.validateToken(token);
        return true;

    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }
}
