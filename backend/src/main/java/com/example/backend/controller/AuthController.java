package com.example.backend.controller;

import com.example.backend.DTO.requestDTO.LoginRequestDTO;
import com.example.backend.DTO.responseDTO.UserResponseDTO;
import com.example.backend.security.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    Map<String,Boolean> map = new HashMap<>();

    //constructor is done by @RequiredArgsConstructor , is basically only with final or @notNull annotations.
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequestDTO));
//        try{
//        }
//        catch(UsernameNotFoundException e){
//            map.clear();
//            map.put("User found",false);
//            map.put("status",false);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
//        }
    }
}
