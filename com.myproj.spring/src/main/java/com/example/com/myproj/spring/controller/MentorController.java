package com.example.com.myproj.spring.controller;

import com.example.com.myproj.spring.service.MentorService;
import com.example.com.myproj.spring.model.Mentor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping
    public ResponseEntity getMentores(){
        return new ResponseEntity(mentorService.getMentor(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMentor(@PathVariable long id){
        return ResponseEntity.ok(mentorService.getMentorByIndex(id));
    }

    @PostMapping
    public ResponseEntity criarMentor(@RequestBody Mentor mentor){
        mentorService.criaMentor(mentor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMentor(@PathVariable long id){
        mentorService.deleteMentor(id);
        return ResponseEntity.ok().build();
    }

}
