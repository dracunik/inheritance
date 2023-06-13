package com.example.inheritance.servicesimplement;

import com.example.inheritance.entities.User;
import com.example.inheritance.repositories.IUserRepository;
import com.example.inheritance.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public List<User> list() {
        return uR.findAll();
    }
}
