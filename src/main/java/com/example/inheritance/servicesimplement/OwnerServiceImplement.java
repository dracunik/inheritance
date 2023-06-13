package com.example.inheritance.servicesimplement;

import com.example.inheritance.entities.Owner;
import com.example.inheritance.repositories.IOwnerRepository;
import com.example.inheritance.services.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImplement implements IOwnerService {
    @Autowired
    private IOwnerRepository oR;
    @Override
    public void insert(Owner owner) {
        oR.save(owner);
    }
    @Override
    public List<Owner> list() {
        return oR.findAll();
    }
    @Override
    public Owner listId(int id) {
        return oR.findById(id).orElse(new Owner());
    }
    @Override
    public void disable(int id) {
        oR.disable(id);
    }
}
