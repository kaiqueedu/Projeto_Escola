package com.example.com.myproj.spring.controller;

import com.example.com.myproj.spring.model.dto.MentoriaDTO;
import com.example.com.myproj.spring.service.MentoriaService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    MentoriaService mentoriaService;

    @GetMapping
    public ResponseEntity getMentoriaa(){

        return new ResponseEntity(mentoriaService.getMetorias(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMentoriaById(@PathVariable Long id){

        return ResponseEntity.ok(mentoriaService.getMentoriaById(id));
    }

    @GetMapping("/active")
    public ResponseEntity getMentoriaByActive(){

        return ResponseEntity.ok(mentoriaService.getMentoriaByActive());
    }

    @PostMapping
    public ResponseEntity criarMentoria(@RequestBody MentoriaDTO dto){
        MentoriaDTO mentoriaSalva = mentoriaService.criaMentoria(dto);
        return ResponseEntity.created(URI.create("/mentoria/" + mentoriaSalva.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMentoria(@PathVariable long id){
        mentoriaService.deleteMentoria(id);
        return ResponseEntity.ok().build();
    }

}
