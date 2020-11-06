package com.example.com.myproj.spring.repository;

import com.example.com.myproj.spring.model.Disciplina;
import com.example.com.myproj.spring.model.Programa;
import com.example.com.myproj.spring.model.dto.DisciplinaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    List<Disciplina> findByActive(Boolean active);

}
