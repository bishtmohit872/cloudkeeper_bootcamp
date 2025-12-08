package com.example.backend.utils;

import com.example.backend.DTO.requestDTO.AddUserRequestDTO;
import com.example.backend.DTO.requestDTO.EditUserRequestDTO;
import com.example.backend.DTO.responseDTO.UserResponseDTO;
import com.example.backend.entity.UserEntity;

// this class is for creating the user via admin
public class Transformer {
    public static UserEntity AddUserRequestDTOtoAddUserEntity(AddUserRequestDTO addUserRequestDTO){
        return UserEntity.builder()
                .firstName(addUserRequestDTO.getFirstName())
                .lastName(addUserRequestDTO.getLastName())
                .email(addUserRequestDTO.getEmail())
                .isActive(false)
                .lastLogin(null)
                .build();

    }

    public static UserResponseDTO UserEntitytoUserResponseDTO(UserEntity userEntity){
        return  UserResponseDTO.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .lastLogin(userEntity.getLastLogin())
                .isActive(userEntity.getIsActive()).build();


    }

    public static UserEntity EditUserRequestDTOtoUserEntity(EditUserRequestDTO editUserRequestDTO){
        return UserEntity.builder()
                .id(editUserRequestDTO.getId())
                .firstName(editUserRequestDTO.getFirstName())
                .lastName(editUserRequestDTO.getLastName())
                .email(editUserRequestDTO.getEmail())
                .isActive(editUserRequestDTO.getIsActive()).build();
    }
}
