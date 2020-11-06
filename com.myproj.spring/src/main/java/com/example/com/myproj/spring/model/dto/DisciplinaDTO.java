package com.example.com.myproj.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO {

    Long disciplinaId;
    String nome;
    Long mentorId;
    Boolean active;
}
