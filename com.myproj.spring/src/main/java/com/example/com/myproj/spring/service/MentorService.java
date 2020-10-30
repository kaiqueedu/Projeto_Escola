package com.example.com.myproj.spring.service;

import com.example.com.myproj.spring.model.Mentor;
import com.example.com.myproj.spring.model.dto.MentorDTO;
import com.example.com.myproj.spring.model.mappers.MentorMapper;
import com.example.com.myproj.spring.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorService {

    //private List<String> list = new ArrayList<>(List.of("Paulo Amaral", "Mentor2"));

    @Autowired
    MentorRepository mentorRepository;

    public List<MentorDTO> getMentores(){
        return mentorRepository.findAll()
                                .stream()
                                .map(MentorMapper::toMentorDTO)
                                .collect(Collectors.toList());
    }

    public MentorDTO getMentorByIndex(long id) {

        return mentorRepository.findById(id).map(MentorMapper::toMentorDTO).orElse(null);
    }

    public List<MentorDTO> getMentorByActive() {

        return mentorRepository.findByActive(true).stream().map(MentorMapper::toMentorDTO).collect(Collectors.toList());
    }

    public MentorDTO criaMentor(MentorDTO mentorDTO) {

        return MentorMapper.toMentorDTO(mentorRepository.save(MentorMapper.toMentor(mentorDTO)));
    }

    public void deleteMentor(long id){

        mentorRepository.deleteById(id);
    }

}
