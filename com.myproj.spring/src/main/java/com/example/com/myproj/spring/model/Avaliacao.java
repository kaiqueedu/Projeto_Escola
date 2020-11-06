package com.example.com.myproj.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avaliacaoId;
    private Long mentorId;
    private Long alunoId;
    private Long disciplinaId;
    private int nota;
    private LocalDate data;
    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private Boolean active;

}
