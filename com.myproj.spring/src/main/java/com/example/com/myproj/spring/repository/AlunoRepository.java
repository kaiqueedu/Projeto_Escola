package com.example.com.myproj.spring.repository;

import com.example.com.myproj.spring.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByActive(Boolean active);
}
