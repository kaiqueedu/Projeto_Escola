package com.example.com.myproj.spring.model.mappers;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.dto.AlunoDTO;

public class AlunoMapper {

    public static AlunoDTO toAlunoDTO(Aluno aluno){
<<<<<<< HEAD:com.myproj.spring/src/main/java/com/example/com/myproj/spring/model/mappers/AlunoMapper.java
       return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getClasse(), aluno.isActive());
    }

    public static Aluno toAluno(AlunoDTO dto){
        return new Aluno(dto.getId(), dto.getNome(), dto.getClasse(), dto.getActive());
=======
       return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getClasse());
    }

    public static Aluno toAluno(AlunoDTO dto){
        return new Aluno(dto.getId(), dto.getNome(), dto.getClasse(), true);
>>>>>>> 5bd4bd5390ea98090e757faf44fbf509ce4913b1:com.myproj.spring/src/main/java/com/example/com/myproj/spring/service/AlunoMapper.java
    }

}
