package com.example.inheritance.services;


import com.example.inheritance.entities.Trainer;

import java.util.List;

public interface ITrainerService {
    void insert(Trainer trainer);
    List<Trainer> list();
    Trainer listId(int id);
    void disable(int id);
}
