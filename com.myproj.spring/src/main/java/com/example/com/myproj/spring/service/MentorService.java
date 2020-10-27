package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Mentor;
import com.example.com.myproj.spring.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    //private List<String> list = new ArrayList<>(List.of("Paulo Amaral", "Mentor2"));

    @Autowired
    MentorRepository mentorRepository;

    public List<Mentor> getMentor(){
        System.out.println("Buscando todos os mentores");
        return mentorRepository.findAll();
    }

    public Optional<Mentor> getMentorByIndex(long id) {
        System.out.println("Buscando mentor pelo id");
        return mentorRepository.findById(id);
    }

    public void criaMentor(Mentor mentor) {
        System.out.println("Inserindo um mentor");
        mentorRepository.save(mentor);
    }

    public void deleteMentor(long id){
        System.out.println("Delentando o mentor: " + id);
        mentorRepository.deleteById(id);
    }

}
