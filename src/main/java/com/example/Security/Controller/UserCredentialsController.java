package com.example.Security.Controller;

import com.example.Security.Entity.Security;

import com.example.Security.Service.JwtService;
import com.example.Security.Service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserCredentialsController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserCredentialsService userCredService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public Security registerUser(@RequestBody Security security){
        return userCredService.register(security);
    }



    @GetMapping("/validate/token")
    public boolean validateToken(@RequestParam String token){
        return userCredService.verifyToken(token);
    }

    @PostMapping("/validate/user")
    public String getToken (@RequestBody Security user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return userCredService.generateToken(user.getUsername());
        }
        return "User not authenticated";
    }
}
