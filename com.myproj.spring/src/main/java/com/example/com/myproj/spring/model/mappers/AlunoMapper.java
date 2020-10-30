package com.example.com.myproj.spring.model.mappers;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.dto.AlunoDTO;

public class AlunoMapper {

    public static AlunoDTO toAlunoDTO(Aluno aluno){
       return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getClasse());
    }

    public static Aluno toAluno(AlunoDTO dto){
        return new Aluno(dto.getId(), dto.getNome(), dto.getClasse(), true);
    }

}
