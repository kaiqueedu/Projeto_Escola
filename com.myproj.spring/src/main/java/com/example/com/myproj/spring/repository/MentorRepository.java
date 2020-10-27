package com.example.com.myproj.spring.repository;

import com.example.com.myproj.spring.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long>  {
}
