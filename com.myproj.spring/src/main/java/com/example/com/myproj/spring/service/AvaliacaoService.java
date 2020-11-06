package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.Avaliacao;
import com.example.com.myproj.spring.model.Mentor;
import com.example.com.myproj.spring.model.dto.AlunoDTO;
import com.example.com.myproj.spring.model.dto.AvaliacaoDTO;
import com.example.com.myproj.spring.model.dto.DisciplinaDTO;
import com.example.com.myproj.spring.model.dto.MentorDTO;
import com.example.com.myproj.spring.model.mappers.AvaliacaoMapper;
import com.example.com.myproj.spring.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    AvaliacaoMapper mapper;

    @Autowired
    MentorService mentorService;

    @Autowired
    AlunoService alunoService;

    @Autowired
    DisciplinaService disciplinaService;

    public List<AvaliacaoDTO> getAvaliacao(Optional<Boolean> active) {
        if(active.isPresent()){
            return avaliacaoRepository.findByActive(active.get())
                                      .stream()
                                      .map(mapper::toAvaliacaoDTO)
                                      .collect(Collectors.toList());
        }

        return avaliacaoRepository.findAll()
                                  .stream()
                                  .map(mapper::toAvaliacaoDTO)
                                  .collect(Collectors.toList());
    }

    public Optional<AvaliacaoDTO> getAvaliacaoById(Long id) {
        return avaliacaoRepository.findById(id)
                                  .map(mapper::toAvaliacaoDTO);

    }

    public AvaliacaoDTO create(AvaliacaoDTO dto) {

        AlunoDTO al = alunoService.getAlunoById(dto.getAlunoId());
        MentorDTO mentor = mentorService.getMentorByIndex(dto.getMentorId());
        DisciplinaDTO disc = disciplinaService.getDisciplinaById(dto.getDisciplinaId());

        if(al == null || mentor == null || disc == null){
            return null; //arrumar
        }
        Avaliacao aval = mapper.toAvaliacao(dto);
        aval.getActive();
        avaliacaoRepository.save(aval);
        return null;
    }

    public void delete(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}
