package com.example.backend.security;

import com.example.backend.DTO.requestDTO.LoginRequestDTO;
import com.example.backend.DTO.responseDTO.LoginResponseDTO;
import com.example.backend.DTO.responseDTO.UserResponseDTO;
import com.example.backend.entity.UserEntity;
import com.example.backend.utils.Transformer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public AuthService(AuthenticationManager authenticationManager,AuthUtil authUtil){
        this.authenticationManager = authenticationManager;
        this.authUtil = authUtil;
    }

    public LoginResponseDTO login(@Valid LoginRequestDTO loginRequestDTO) throws UsernameNotFoundException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),loginRequestDTO.getPassword()));
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(userDetails);

        UserResponseDTO userResponseDTO = Transformer.UserEntitytoUserResponseDTO(userDetails);

        return LoginResponseDTO.builder()
                .Jwt(token)
                .userResponseDTO(userResponseDTO)
                .build();
    }
}
