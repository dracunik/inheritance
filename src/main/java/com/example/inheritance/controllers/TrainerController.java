package com.example.inheritance.controllers;

import com.example.inheritance.dtos.OwnerDTO;
import com.example.inheritance.dtos.TrainerDTO;
import com.example.inheritance.entities.Owner;
import com.example.inheritance.entities.Trainer;
import com.example.inheritance.services.ITrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private ITrainerService tS;
    @GetMapping
    public List<TrainerDTO> list() {
        return tS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, TrainerDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public TrainerDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        TrainerDTO dto = m.map(tS.listId(id), TrainerDTO.class);
        return dto;
    }
    @PostMapping
    public void insert(@RequestBody TrainerDTO dto) {
        ModelMapper m = new ModelMapper();
        Trainer t = m.map(dto, Trainer.class);
        tS.insert(t);
    }
    @PutMapping
    public void update(@RequestBody TrainerDTO dto) {
        ModelMapper m = new ModelMapper();
        Trainer t = m.map(dto, Trainer.class);
        tS.insert(t);
    }
    @PutMapping("/{id}")
    public void disable(@PathVariable("id") Integer id){
        tS.disable(id);
    }
}
