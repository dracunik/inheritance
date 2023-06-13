package com.example.inheritance.servicesimplement;

import com.example.inheritance.entities.Nutritionist;
import com.example.inheritance.repositories.INutritionistRepository;
import com.example.inheritance.services.INutritionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionistServiceImplement implements INutritionistService {
    @Autowired
    private INutritionistRepository nR;

    @Override
    public void insert(Nutritionist nutritionist) {
        nR.save(nutritionist);
    }
    @Override
    public List<Nutritionist> list() {
        return nR.findAll();
    }
    @Override
    public Nutritionist listId(int id) {
        return nR.findById(id).orElse(new Nutritionist());
    }
    @Override
    public void disable(int id) {
        nR.disable(id);
    }
}
