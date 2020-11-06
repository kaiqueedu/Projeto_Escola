package com.example.com.myproj.spring.controller;

import com.example.com.myproj.spring.model.Disciplina;
import com.example.com.myproj.spring.model.dto.DisciplinaDTO;
import com.example.com.myproj.spring.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity getDisciplina(@RequestParam("active")Optional<Boolean> active){
        return new ResponseEntity<>(disciplinaService.getDisciplina(active), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDisciplinaById(@PathVariable Long id){
        return ResponseEntity.ok(disciplinaService.getDisciplinaById(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody DisciplinaDTO dto){
        DisciplinaDTO disciplinaSalvo = disciplinaService.create(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(Long id){
        disciplinaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
