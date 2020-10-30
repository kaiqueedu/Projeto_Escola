package com.example.com.myproj.spring.repository;

import com.example.com.myproj.spring.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor, Long>  {

    List<Mentor> findByActive(Boolean active);
}
