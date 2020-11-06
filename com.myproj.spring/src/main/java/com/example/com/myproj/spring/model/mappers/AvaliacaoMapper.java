package com.example.com.myproj.spring.model.mappers;

import com.example.com.myproj.spring.model.Avaliacao;
import com.example.com.myproj.spring.model.dto.AvaliacaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AvaliacaoMapper {

    AvaliacaoDTO toAvaliacaoDTO(Avaliacao avaliacao);

    Avaliacao toAvaliacao(AvaliacaoDTO dto);

}
