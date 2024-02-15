package com.example.demo.service;

import com.example.demo.dto.userDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class UserService {
    @Autowired
    UserRepo userrepo;
    @Autowired
    private ModelMapper modelMapper;
    public userDTO saveUser(userDTO userdto){
        userrepo.save(modelMapper.map(userdto, User.class));
        return userdto;
    }


    //getAll
    public List<userDTO> getAllUsers(){
        List<User> userList = userrepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<userDTO>>(){}.getType());

    }
}
