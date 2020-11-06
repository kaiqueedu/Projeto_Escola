package com.example.com.myproj.spring.controller;

import com.example.com.myproj.spring.model.dto.AvaliacaoDTO;
import com.example.com.myproj.spring.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity getAvaliacao(@RequestParam("active") Optional<Boolean> active){
        return new ResponseEntity<>(avaliacaoService.getAvaliacao(active), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAvaliacaoById(@PathVariable Long id){
        return ResponseEntity.ok(avaliacaoService.getAvaliacaoById(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AvaliacaoDTO dto){
        AvaliacaoDTO avaliacaoSalvo = avaliacaoService.create(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(Long id){
        avaliacaoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
