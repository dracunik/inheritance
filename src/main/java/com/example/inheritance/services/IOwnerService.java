package com.example.inheritance.services;

import com.example.inheritance.entities.Owner;

import java.util.List;

public interface IOwnerService {
    void insert(Owner owner);
    List<Owner> list();
    Owner listId(int id);
    void disable(int id);
}
