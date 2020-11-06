package com.example.com.myproj.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {

    private Long avaliacaoId;
    private Long mentorId;
    private Long alunoId;
    private Long disciplinaId;
    private int nota;
    private LocalDate data;
    private Boolean active;

}
