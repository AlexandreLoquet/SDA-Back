package com.spring.rest.repositories;

import com.spring.rest.entities.Animaux;

import com.spring.rest.entities.Sda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AnimauxRepository extends JpaRepository<Animaux, Long> {


    @Query("select a from Animaux a where a.sda = :sda_id")
    List<Animaux> findAnimauxBySda_id(@Param("sda_id") Sda sda);

    @Query("select a from Animaux a where a.types = :types")
    List<Animaux> findAnimauxByTypes(@Param("types") String types);


}
