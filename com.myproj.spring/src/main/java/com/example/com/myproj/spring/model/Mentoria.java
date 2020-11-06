package com.example.com.myproj.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Mentoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name="mentor_id")
    private Mentor mentor;

<<<<<<< HEAD
    private LocalDate dataInicio;
=======
    private Instant dataInicio;
>>>>>>> 5bd4bd5390ea98090e757faf44fbf509ce4913b1
    private LocalDate dataFim;

    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private Boolean active;


}
