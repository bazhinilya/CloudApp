package ru.cloudapp.authorization_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ru.cloudapp.authorization_service.config.JwtTokenUtil;
import ru.cloudapp.authorization_service.model.JwtRequest;
import ru.cloudapp.authorization_service.model.JwtResponse;
import ru.cloudapp.authorization_service.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtRequest request)
            throws Exception {
        userService.authenticate(request.getUsername());
        return ResponseEntity.ok(JwtResponse.builder()
                .jwttoken(jwtTokenUtil.generateToken(request.getUsername()))
                .build());
    }
}