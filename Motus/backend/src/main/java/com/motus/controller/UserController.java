package com.motus.controller;
import com.motus.entity.User;
import com.motus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired private UserRepository userRepo;
    @Autowired private PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody User u) {
        u.setPassword(encoder.encode(u.getPassword()));
        userRepo.save(u);
        return "OK";
    }
}