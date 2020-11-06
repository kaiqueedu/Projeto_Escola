package com.example.com.myproj.spring.repository;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramaRepository extends JpaRepository<Programa, Long> {

    List<Programa> findByActive(Boolean active);
}
