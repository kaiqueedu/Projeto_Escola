package com.example.com.myproj.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long disciplinaId;
    String nome;
    Long mentorId;
    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    Boolean active;
}
