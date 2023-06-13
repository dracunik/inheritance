package com.example.inheritance.services;

import com.example.inheritance.entities.Nutritionist;

import java.util.List;

public interface INutritionistService {
    void insert(Nutritionist nutritionist);
    List<Nutritionist> list();
    Nutritionist listId(int id);
    void disable(int id);
}
