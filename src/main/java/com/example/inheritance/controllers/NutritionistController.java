package com.example.inheritance.controllers;

import com.example.inheritance.dtos.NutritionistDTO;
import com.example.inheritance.entities.Nutritionist;
import com.example.inheritance.services.INutritionistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nutritionists")
public class NutritionistController {
    @Autowired
    private INutritionistService nS;
    @GetMapping
    public List<NutritionistDTO> list() {
        return nS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, NutritionistDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public NutritionistDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        NutritionistDTO dto = m.map(nS.listId(id), NutritionistDTO.class);
        return dto;
    }
    @PostMapping
    public void insert(@RequestBody NutritionistDTO dto) {
        ModelMapper m = new ModelMapper();
        Nutritionist t = m.map(dto, Nutritionist.class);
        nS.insert(t);
    }
    @PutMapping
    public void update(@RequestBody NutritionistDTO dto) {
        ModelMapper m = new ModelMapper();
        Nutritionist t = m.map(dto, Nutritionist.class);
        nS.insert(t);
    }
    @PutMapping("/{id}")
    public void disable(@PathVariable("id") Integer id){
        nS.disable(id);
    }
}
