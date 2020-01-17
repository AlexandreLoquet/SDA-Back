package com.spring.rest.repositories;

import com.spring.rest.entities.Animals;

import com.spring.rest.entities.Sda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {


    @Query("select a from Animals a where a.sda = :sda_id")
    List<Animals> findAnimalsBySda_id(@Param("sda_id") Sda sda);

    @Query("select a from Animals a where a.types = :types")
    List<Animals> findAnimalsByTypes(@Param("types") String types);

    @Query(value = "select a from Animals a where a.isAdopt = FALSE")
    List<Animals> findFreeAnimals();

    @Query(value = "select distinct a.types from Animals a")
    List<String> findTypesOfAnimals();

}
