package com.example.com.myproj.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentorDTO {

    private long id;
    private String nome;
    private String materia;
    private Boolean active;

}
