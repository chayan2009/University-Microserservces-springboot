package com.university.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.student_service.entity.Student;

public interface StudentRepostiory extends JpaRepository<Student,Long> {
    
}
