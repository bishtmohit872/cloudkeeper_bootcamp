package com.example.backend.DTO.responseDTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UserResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate lastLogin;
    private Boolean isActive;
}
