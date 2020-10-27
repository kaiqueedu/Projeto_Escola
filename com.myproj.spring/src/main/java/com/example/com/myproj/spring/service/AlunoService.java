package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.dto.AlunoDTO;
import com.example.com.myproj.spring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    public List<Aluno> getAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<AlunoDTO> getAlunoById(@PathVariable long id){
        return alunoRepository.findById(id).map(AlunoMapper::toAlunoDTO);
    }

    public AlunoDTO criaAluno(@RequestBody AlunoDTO dto){
        Aluno aluno = AlunoMapper.toAluno(dto);
        alunoRepository.save(aluno);
        return AlunoMapper.toAlunoDTO(aluno);
    }

    public void deleteAluno(@PathVariable long id){
        alunoRepository.deleteById((id));
    }

    public Optional<List<Aluno>> getAlunosAtivos() {
        return alunoRepository.findByActive(true);
    }

}
