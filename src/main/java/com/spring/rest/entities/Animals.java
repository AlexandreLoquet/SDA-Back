package com.spring.rest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animals {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nom")
    private String name;

    @Column(name="type")
    private String types;

    @Column(name="isAdopte")
    private boolean isAdopt;

    @Column(name="dateAdopte")
    private Date AdoptionDate;

    @ManyToOne
    @JoinColumn(name="sda_id")
    private Sda sda;

    @ManyToOne
    @JoinColumn(name="adoptant_id")
    private Users carer;

}
