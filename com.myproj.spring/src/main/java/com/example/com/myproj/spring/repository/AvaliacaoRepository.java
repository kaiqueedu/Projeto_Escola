package com.example.com.myproj.spring.repository;

import com.example.com.myproj.spring.model.Avaliacao;
import com.example.com.myproj.spring.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    List<Avaliacao> findByActive(Boolean active);
}
