package com.example.demo.controller;

import com.example.demo.dto.userDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin

public class UserController {
    @GetMapping("/getUsers")
    public List<userDTO> getUser(){
        return userservice.getAllUsers();
    }

    @Autowired
    private UserService userservice;
    @PostMapping("/saveUser")
    public userDTO saveUser(@RequestBody userDTO userdto){
        userservice.saveUser(userdto);
        return userdto;
    }

    @PutMapping
    public String editUser(){
        return "user edited!!";
    }

    @DeleteMapping
    public String deleteUser(){
        return "user deleted!!";
    }
     
}

