package com.spring.rest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animaux {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nom")
    private String nom;

    @Column(name="type")
    private String types;

    @Column(name="isAdopte")
    private boolean isAdopte;

    @ManyToOne
    @JoinColumn(name="sda_id")
    private Sda sda;

    @ManyToOne
    @JoinColumn(name="adoptant_id")
    private Users adoptant;

}
