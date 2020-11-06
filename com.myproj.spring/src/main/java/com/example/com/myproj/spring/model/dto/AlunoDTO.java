package com.example.com.myproj.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;
    private String nome;
    private String classe;
    private Boolean active;

}
