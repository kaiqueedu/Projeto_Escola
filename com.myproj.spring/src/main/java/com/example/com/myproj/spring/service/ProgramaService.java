package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Programa;
import com.example.com.myproj.spring.model.dto.ProgramaDTO;
import com.example.com.myproj.spring.model.mappers.ProgramaMapper;
import com.example.com.myproj.spring.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;

    @Autowired
    private ProgramaMapper mapper;

    public List<ProgramaDTO> getProgramas(Optional<Boolean> active){

        if(active.isPresent()){
            return programaRepository.findByActive(active.get())
                                     .stream()
                                     .map(mapper::toProgramDTO)
                                     .collect(Collectors.toList());
        }

        return programaRepository.findAll()
                                 .stream()
                                 .map(mapper::toProgramDTO)
                                 .collect(Collectors.toList());
    }


    public Optional<ProgramaDTO> getProgramaById(long id) {
        return programaRepository.findById(id)
                                 .map(mapper::toProgramDTO);
    }

    public ProgramaDTO save(ProgramaDTO dto) {
        Programa programa = mapper.toPrograma(dto);
        programa.setActive(true);
        return mapper.toProgramDTO( programaRepository.save( programa ) );
    }

    public void delete(long id) {
        programaRepository.deleteById(id);
    }
}
