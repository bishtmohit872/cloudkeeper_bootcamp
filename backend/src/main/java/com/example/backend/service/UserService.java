package com.example.backend.service;

import com.example.backend.DTO.requestDTO.AddUserRequestDTO;
import com.example.backend.DTO.requestDTO.EditUserRequestDTO;
import com.example.backend.DTO.responseDTO.UserResponseDTO;
import com.example.backend.entity.UserEntity;
import com.example.backend.exception.ElementNotFound;
import com.example.backend.repository.UserRepository;
import com.example.backend.utils.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserResponseDTO> getAllUsers(){
        List<UserEntity> users = userRepository.findAll();
        List<UserResponseDTO> allUsers = users.stream().map(user->Transformer.UserEntitytoUserResponseDTO(user)).collect(Collectors.toList());
        return allUsers;
    }

    public UserResponseDTO getUserById(Long id){
        UserEntity user =  userRepository.findById(id).orElseThrow(()->new ElementNotFound("User Not Found with id: " +id));
        return Transformer.UserEntitytoUserResponseDTO(user);
    }

    public void addUserDetails(AddUserRequestDTO addUserRequestDTO){
        userRepository.save(Transformer.AddUserRequestDTOtoAddUserEntity(addUserRequestDTO));
    }

    public UserResponseDTO editUserDetails(EditUserRequestDTO editUserRequestDTO, Long userId){

        UserEntity oldUser = userRepository.findById(userId).orElse(null);
        if(oldUser !=null){
            oldUser.setFirstName(editUserRequestDTO.getFirstName()!=null && !editUserRequestDTO.getFirstName().isEmpty() ? editUserRequestDTO.getFirstName() : oldUser.getFirstName() );
            oldUser.setLastName(editUserRequestDTO.getLastName()!=null && !editUserRequestDTO.getLastName().isEmpty() ? editUserRequestDTO.getLastName() : oldUser.getLastName());
            oldUser.setEmail(editUserRequestDTO.getEmail()!=null && !editUserRequestDTO.getEmail().isEmpty() ? editUserRequestDTO.getEmail() : oldUser.getEmail() );
            oldUser.setIsActive(editUserRequestDTO.getIsActive());

            userRepository.save(oldUser);
            return Transformer.UserEntitytoUserResponseDTO(oldUser);
        }
        throw new ElementNotFound("No Such user found with this id:"+userId);
    }

    public void deleteUserDetails(Long Id){
        userRepository.deleteById(Id);
    }

}
