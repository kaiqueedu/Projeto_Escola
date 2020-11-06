package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.Mentor;
import com.example.com.myproj.spring.model.Mentoria;
import com.example.com.myproj.spring.model.dto.MentoriaDTO;
import com.example.com.myproj.spring.model.mappers.MentoriaMapper;
import com.example.com.myproj.spring.repository.AlunoRepository;
import com.example.com.myproj.spring.repository.MentorRepository;
import com.example.com.myproj.spring.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentoriaService {

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    MentorRepository mentorRepository;

    public List<MentoriaDTO> getMetorias() {

        return mentoriaRepository.findAll()
                                 .stream()
                                 .map(MentoriaMapper::toMentoriaDTO)
                                 .collect(Collectors.toList());
    }

    public MentoriaDTO getMentoriaById(Long id) {

        return mentoriaRepository.findById(id).map(MentoriaMapper::toMentoriaDTO).orElse(null);
    }

    public List<MentoriaDTO> getMentoriaByActive() {

        return mentoriaRepository.findByActive(true)
                                 .stream()
                                 .map(MentoriaMapper::toMentoriaDTO)
                                 .collect(Collectors.toList());
    }

    public MentoriaDTO criaMentoria(MentoriaDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId()).orElse(null);
        Mentor mentor = mentorRepository.findById(dto.getMentorId()).orElse(null);

        if(aluno == null || mentor == null) {
            return null;
        }

<<<<<<< HEAD
        LocalDate dataInicio = LocalDate.now();
=======
        Instant dataInicio = Instant.now();
>>>>>>> 5bd4bd5390ea98090e757faf44fbf509ce4913b1

        return MentoriaMapper.toMentoriaDTO(mentoriaRepository.save( new Mentoria(null,aluno, mentor, dataInicio, dto.getDataFim(), true) ) );

    }

    public void deleteMentoria(long id) {

        mentoriaRepository.deleteById(id);
    }

}
