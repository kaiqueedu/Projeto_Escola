package com.example.com.myproj.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String materia;
    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private Boolean active;

    public Mentor(Long id, String nome, String materia){
        this.id = id;
        this.nome = nome;
        this.materia = materia;
        active = true;
    }


}
