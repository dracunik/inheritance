package com.example.inheritance.repositories;

import com.example.inheritance.entities.Nutritionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface INutritionistRepository extends JpaRepository<Nutritionist, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Nutritionist n SET n.status = false WHERE n.id =:id")
    void disable(@Param("id") Integer id);
}
