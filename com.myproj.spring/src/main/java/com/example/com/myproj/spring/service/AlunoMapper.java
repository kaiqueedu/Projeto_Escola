package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.dto.AlunoDTO;

public class AlunoMapper {

    public static AlunoDTO toAlunoDTO(Aluno aluno){
       return new AlunoDTO(aluno.getId(), aluno.getName(), aluno.getClasse(), aluno.isActive());
    }

    public static Aluno toAluno(AlunoDTO dto){
        return new Aluno(dto.getId(), dto.getName(), dto.getClasse(), dto.isActive());
    }

}
