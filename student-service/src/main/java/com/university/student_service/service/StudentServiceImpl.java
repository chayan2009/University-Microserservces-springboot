package com.university.student_service.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.university.student_service.dto.StudentDTO;
import com.university.student_service.entity.Student;
import com.university.student_service.repository.StudentRepostiory;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
   
    private ModelMapper modelMapper;

    private StudentRepostiory studentRepostiory;

    public StudentDTO addStudent(StudentDTO addStudent) {

        Student student=modelMapper.map(addStudent, Student.class);

        Student saveAddress=studentRepostiory.save(student);

        return modelMapper.map(saveAddress,StudentDTO.class);

    }

    @Override
    public StudentDTO getStudentById(Long id) {

        Student address = studentRepostiory.findById(id).orElse(null);
        if (address != null) {
            return modelMapper.map(address, StudentDTO.class);
        }
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudent() {

        List<Student> addresses = studentRepostiory.findAll();

        return addresses.stream().map((address) -> modelMapper.map(address, StudentDTO.class))
                .collect(Collectors.toList());
    }
    
}
