package com.example.com.myproj.spring.model.mappers;

import com.example.com.myproj.spring.model.Disciplina;
import com.example.com.myproj.spring.model.dto.DisciplinaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DisciplinaMapper {

    Disciplina toDisciplina(DisciplinaDTO dto);

    DisciplinaDTO toDisciplinaDTO(Disciplina disciplina);

}
