package com.microservice.user.controller;


import com.microservice.user.dtos.UsersRecordDTO;
import com.microservice.user.models.*;
import com.microservice.user.repositories.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users/")
    public ResponseEntity<List<UsersModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usersRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable(value = "id")UUID id){
        Optional<UsersModel> user = usersRepository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(user);

    }

    @PostMapping("/users/record")
    public ResponseEntity<UsersModel> postUsers(@RequestBody UsersRecordDTO usersRecord){
        var usersModel = new UsersModel();
        BeanUtils.copyProperties(usersRecord, usersModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(usersRepository.save(usersModel));

    }

    @PostMapping("/users/update/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable(value="id") UUID id, @RequestBody UsersModel usersModel){
        Optional<UsersModel> user = usersRepository.findById(id);
        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usersRepository.save(usersModel));

    }
    @GetMapping("/users/delete")
    public ResponseEntity<Object> deleteUserById (@PathVariable(value = "id") UUID id){
        Optional<UsersModel> user = usersRepository.findById(id);
        if(user.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        usersRepository.delete(user.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
