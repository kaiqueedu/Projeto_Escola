package com.example.com.myproj.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaDTO {

    private Long programaId;
    private String nome;
    private int duracao;
    private Boolean active;

}
