package com.example.com.myproj.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programaId;
    private String nome;
    private int duracao;
    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private Boolean active;

    public Programa(Long programaId, String nome, int duracao) {
        this.programaId = programaId;
        this.nome = nome;
        this.duracao = duracao;
        this.active = true;
    }

}
