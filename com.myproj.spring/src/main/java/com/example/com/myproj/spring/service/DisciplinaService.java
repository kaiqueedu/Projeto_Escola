package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Disciplina;
import com.example.com.myproj.spring.model.Mentor;
import com.example.com.myproj.spring.model.dto.DisciplinaDTO;
import com.example.com.myproj.spring.model.dto.MentorDTO;
import com.example.com.myproj.spring.model.mappers.DisciplinaMapper;
import com.example.com.myproj.spring.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    MentorService mentorService;

    @Autowired
    DisciplinaMapper mapper;

    public List<DisciplinaDTO> getDisciplina(Optional<Boolean> active) {

        if(active.isPresent()){
            return disciplinaRepository.findByActive(active.get())
                                       .stream()
                                       .map(mapper::toDisciplinaDTO)
                                       .collect(Collectors.toList());
        }
        return disciplinaRepository.findAll()
                                   .stream()
                                   .map(mapper::toDisciplinaDTO)
                                   .collect(Collectors.toList());
    }

    public DisciplinaDTO getDisciplinaById(long id){
        return disciplinaRepository.findById(id)
                                   .map(mapper::toDisciplinaDTO).orElse(null);
    }


    public DisciplinaDTO create(DisciplinaDTO dto){
        Disciplina disciplina = mapper.toDisciplina(dto);
        disciplina.setActive(true);
        MentorDTO mentor = mentorService.getMentorByIndex(disciplina.getMentorId());

        if(mentor == null){
            return null;
        }

        return mapper.toDisciplinaDTO(disciplinaRepository.save(disciplina));
    }


    public void delete(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
