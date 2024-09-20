package com.university.student_service.service;

import java.util.List;
import com.university.student_service.dto.StudentDTO;

public interface StudentService {
    
    StudentDTO addStudent(StudentDTO addStudent);
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudent();
}
