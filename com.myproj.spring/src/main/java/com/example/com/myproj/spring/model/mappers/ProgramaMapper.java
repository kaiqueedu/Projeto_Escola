package com.example.com.myproj.spring.model.mappers;

import com.example.com.myproj.spring.model.Programa;
import com.example.com.myproj.spring.model.dto.ProgramaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ProgramaMapper {

    ProgramaDTO toProgramDTO(Programa programa);

    Programa toPrograma(ProgramaDTO dto);

}

