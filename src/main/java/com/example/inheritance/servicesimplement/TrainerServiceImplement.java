package com.example.inheritance.servicesimplement;

import com.example.inheritance.entities.Trainer;
import com.example.inheritance.repositories.ITrainerRepository;
import com.example.inheritance.services.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImplement implements ITrainerService {
    @Autowired
    private ITrainerRepository tR;

    @Override
    public void insert(Trainer trainer) {
        tR.save(trainer);
    }
    @Override
    public List<Trainer> list() {
        return tR.findAll();
    }
    @Override
    public Trainer listId(int id) {
        return tR.findById(id).orElse(new Trainer());
    }
    @Override
    public void disable(int id) {
        tR.disable(id);
    }
}
