package com.example.com.myproj.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String classe;
    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private boolean active = true;

    public Aluno(Long id, String nome, String classe){
        this.id = id;
        this.nome = nome;
        this.classe = classe;
        active = true;
    }

}
