package com.example.com.myproj.spring.repository;

import com.example.com.myproj.spring.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentoriaRepository extends JpaRepository<Aluno, Long> {

}
