package com.superheros.ingrid.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "superheroes")
@Data
public class SuperheroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

   
    @Column(name = "name")
    private String name;

    @Column(name = "real_name")
    private String realName;


    @Column(name = "power", nullable = false)
    private double power;
}