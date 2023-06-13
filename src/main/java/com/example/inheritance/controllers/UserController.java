package com.example.inheritance.controllers;

import com.example.inheritance.dtos.UserDTO;
import com.example.inheritance.entities.User;
import com.example.inheritance.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService uS;
    @GetMapping
    public List<UserDTO> list() {
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }
}
