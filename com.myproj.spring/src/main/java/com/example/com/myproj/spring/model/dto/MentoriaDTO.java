package com.example.com.myproj.spring.model.dto;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.Mentor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MentoriaDTO {

    private Long id;
    private Long alunoId;
    private Long mentorId;
<<<<<<< HEAD
    private LocalDate dataInicio;
=======
    private Instant dataInicio;
>>>>>>> 5bd4bd5390ea98090e757faf44fbf509ce4913b1
    private LocalDate dataFim;

}
