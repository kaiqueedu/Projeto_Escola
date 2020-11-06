package com.example.com.myproj.spring.model.mappers;

import com.example.com.myproj.spring.model.Mentor;
import com.example.com.myproj.spring.model.dto.MentorDTO;

public class MentorMapper {

    public static Mentor toMentor(MentorDTO dto){

        return new Mentor(dto.getId(), dto.getNome(), dto.getMateria(), true);
    }

    public static MentorDTO toMentorDTO(Mentor m){

<<<<<<< HEAD
        return new MentorDTO(m.getId(), m.getNome(), m.getMateria());
=======
        return new MentorDTO(m.getId(), m.getNome(), m.getMateria(), m.getActive());
>>>>>>> 5bd4bd5390ea98090e757faf44fbf509ce4913b1
    }

}
