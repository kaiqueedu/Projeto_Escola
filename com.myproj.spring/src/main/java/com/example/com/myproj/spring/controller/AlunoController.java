package com.example.com.myproj.spring.controller;

import com.example.com.myproj.spring.model.dto.AlunoDTO;
import com.example.com.myproj.spring.repository.AlunoRepository;
import com.example.com.myproj.spring.service.AlunoService;
import com.example.com.myproj.spring.model.Aluno;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Getter
@RestController
//RestController diz para o sprint que essa classe vai atender uma requisião url
//caminho da classe
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    //private AlunoService alunoService;
    //essa anotação faz com o não preciso dar o new

    //@GetMapping("/jovem-pan")
    //localhost/8080/aluno/jovem-apan
    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAlunos(){

        return new ResponseEntity<>(alunoService.getAlunos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAlunoById(@PathVariable Long id){

        return ResponseEntity.ok(alunoService.getAlunoById(id));
    }

    @GetMapping("/active")
    public ResponseEntity getAlunosAtivos(){

        return ResponseEntity.ok(alunoService.getAlunosAtivos());
    }

    // aqui pega no body da resquest
    @PostMapping
    public ResponseEntity<Boolean> criaAluno(@RequestBody AlunoDTO dto){
        AlunoDTO alunoSalvo = alunoService.criaAluno(dto);
        return ResponseEntity.created( URI.create("/aluno/" + alunoSalvo.getId() ) ).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAluno(@PathVariable long id){
        alunoService.deleteAluno((int)id);
        return ResponseEntity.ok().build();
    }

}
