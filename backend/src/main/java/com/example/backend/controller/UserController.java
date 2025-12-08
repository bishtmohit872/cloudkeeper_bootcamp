package com.example.backend.controller;

import com.example.backend.DTO.requestDTO.AddUserRequestDTO;
import com.example.backend.DTO.requestDTO.EditUserRequestDTO;
import com.example.backend.DTO.responseDTO.UserResponseDTO;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    Map<String,Boolean> map = new HashMap<>();

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> fetchUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<Object> saveUser(@RequestBody AddUserRequestDTO addUserRequestDTO){
        userService.addUserDetails(addUserRequestDTO);
        map.clear();
        map.put("UserCreated",true);
        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }

    @PutMapping("/editUser/{id}")
    public ResponseEntity<UserResponseDTO> editUser(@RequestBody EditUserRequestDTO editUserRequestDTO, @PathVariable(name="id") Long userId){
        return new ResponseEntity<>(userService.editUserDetails(editUserRequestDTO,userId),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable(name="id") Long Id){
        map.clear();
        map.put("status",true);
        userService.deleteUserDetails(Id);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }


}
