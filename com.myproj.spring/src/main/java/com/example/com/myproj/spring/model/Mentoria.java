package com.example.com.myproj.spring.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Mentoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="aluno_id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name="mentor_id")
    private Mentor mentor;

}
