package com.example.com.myproj.spring.repository;

import com.example.com.myproj.spring.model.Aluno;
import com.example.com.myproj.spring.model.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentoriaRepository extends JpaRepository<Mentoria, Long> {

    List<Mentoria> findByActive(Boolean active);

}
