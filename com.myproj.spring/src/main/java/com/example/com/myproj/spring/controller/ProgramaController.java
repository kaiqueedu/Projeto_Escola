package com.example.com.myproj.spring.controller;

import com.example.com.myproj.spring.model.dto.ProgramaDTO;
import com.example.com.myproj.spring.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/programa")
public class ProgramaController {

    @Autowired
    ProgramaService programaService;

    @GetMapping
    public ResponseEntity getProgramas(@RequestParam("active")Optional<Boolean> active){
        return new ResponseEntity<>(programaService.getProgramas(active), HttpStatus.ACCEPTED);
    }


    @GetMapping("/{id}")
    public ResponseEntity getProgramaById(@PathVariable long id){
        return ResponseEntity.ok(programaService.getProgramaById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProgramaDTO dto){
        ProgramaDTO programaSalvo = programaService.save(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id){
        programaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
