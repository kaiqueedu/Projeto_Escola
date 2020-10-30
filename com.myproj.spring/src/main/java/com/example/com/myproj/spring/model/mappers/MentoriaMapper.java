package com.example.com.myproj.spring.model.mappers;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.Mentor;
import com.example.com.myproj.spring.model.Mentoria;
import com.example.com.myproj.spring.model.dto.MentoriaDTO;
import com.example.com.myproj.spring.repository.MentorRepository;
import com.example.com.myproj.spring.service.AlunoService;
import com.example.com.myproj.spring.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;

public class MentoriaMapper {

    public static Mentoria toMentoria(MentoriaDTO dto, Aluno aluno, Mentor mentor){

        return new Mentoria(dto.getId(), aluno, mentor, dto.getDataInicio(), dto.getDataFim(), true);
    }

    public static MentoriaDTO toMentoriaDTO(Mentoria mentoria){
        return new MentoriaDTO(mentoria.getId(), mentoria.getAluno().getId(),
                               mentoria.getMentor().getId(), mentoria.getDataInicio(),
                               mentoria.getDataFim());
    }

}
