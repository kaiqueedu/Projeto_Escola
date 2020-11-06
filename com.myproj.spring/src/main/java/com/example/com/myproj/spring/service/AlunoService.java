package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.dto.AlunoDTO;
import com.example.com.myproj.spring.model.mappers.AlunoMapper;
import com.example.com.myproj.spring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    // essa classe é responsavel para validar algumas coisas da aplicação
    // pode validar algum "regra de nogócio"
    //por exemplo: validar se existe algum aluno na base, caso não retornar
    //alguma mensagem.
    //Ou tbm essa classe serve para chamar alguma classe com a regra referente ao aluno

    //private List<String> list = new ArrayList<String>(List.of("Kaique", "Luana", "Thiago", "Mãe"));

    //public List<Aluno> getAluno(){ System.out.println("Teste service Aluno");
    //    return null;
    //}

    //public String getAlunoByIndex(Long id) {        return list.get(id.intValue());    }
    //public void criaAluno(Aluno aluno) {        list.add(aluno.getName());    }
    //public void deleteAluno(long id){        list.remove(id);    }

    @Autowired
    AlunoRepository alunoRepository;

    public List<AlunoDTO> getAlunos(Optional<Boolean> active) {

        if (active.isPresent()) {
            return alunoRepository.findByActive(active.get())
                                  .stream()
                                  .map(AlunoMapper::toAlunoDTO)
                                  .collect(Collectors.toList());
        }

        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper::toAlunoDTO)
                .collect(Collectors.toList());
    }

    public AlunoDTO getAlunoById(@PathVariable Long id) {
        //return AlunoMapper.toAlunoDTO(alunoRepository.findById(id));
        return alunoRepository.findById(id).map(AlunoMapper::toAlunoDTO).orElse(null); // Lançar exception
    }

    public AlunoDTO criaAluno(@RequestBody AlunoDTO dto) {

        return AlunoMapper.toAlunoDTO(alunoRepository.save(AlunoMapper.toAluno(dto)));
    }

    public void deleteAluno(@PathVariable long id) {

        alunoRepository.deleteById(id);
    }

    public List<AlunoDTO> getAlunosAtivos() {

        return alunoRepository.findByActive(true).stream().map(AlunoMapper::toAlunoDTO).collect(Collectors.toList());
    }

}
