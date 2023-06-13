package com.example.inheritance.controllers;

import com.example.inheritance.dtos.OwnerDTO;
import com.example.inheritance.entities.Owner;
import com.example.inheritance.services.IOwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private IOwnerService oS;
    @GetMapping
    public List<OwnerDTO> list() {
        return oS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, OwnerDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public OwnerDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        OwnerDTO dto = m.map(oS.listId(id), OwnerDTO.class);
        return dto;
    }
    @PostMapping
    public void insert(@RequestBody OwnerDTO dto) {
        ModelMapper m = new ModelMapper();
        Owner o = m.map(dto, Owner.class);
        oS.insert(o);
    }
    @PutMapping
    public void update(@RequestBody OwnerDTO dto) {
        ModelMapper m = new ModelMapper();
        Owner o = m.map(dto, Owner.class);
        oS.insert(o);
    }
    @PutMapping("/{id}")
    public void disable(@PathVariable("id") Integer id){
        oS.disable(id);
    }
}
