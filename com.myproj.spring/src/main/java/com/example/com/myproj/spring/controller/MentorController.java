package com.example.com.myproj.spring.controller;

import com.example.com.myproj.spring.model.dto.MentorDTO;
import com.example.com.myproj.spring.service.MentorService;
import com.example.com.myproj.spring.model.Mentor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Getter
@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    public ResponseEntity getMentores(){

        return new ResponseEntity(mentorService.getMentores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMentor(@PathVariable long id){

        return ResponseEntity.ok(mentorService.getMentorByIndex(id));
    }

    @GetMapping("/active")
    public ResponseEntity getMentorByActive(){

        return ResponseEntity.ok(mentorService.getMentorByActive());
    }

    @PostMapping
    public ResponseEntity criarMentor(@RequestBody MentorDTO mentorDTO){
        MentorDTO mentorSalvo  = mentorService.criaMentor(mentorDTO);
        return ResponseEntity.created(URI.create("/mentor/" + mentorSalvo.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMentor(@PathVariable long id){
        mentorService.deleteMentor(id);
        return ResponseEntity.ok().build();
    }

}
