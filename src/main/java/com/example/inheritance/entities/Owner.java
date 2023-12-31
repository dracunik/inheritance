package com.example.inheritance.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "owners")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Owner extends User{
    public Owner() {
    }
    public Owner(int id, String name, String lastname, String gender, int age, LocalDate birthDate, int cellphone, String email, String dni, boolean status) {
        super(id, name, lastname, gender, age, birthDate, cellphone, email, dni, status);
    }
}

