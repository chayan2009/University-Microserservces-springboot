package com.university.student_service.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.university.address_service.utils.AddressClient;
import com.university.student_service.dto.AddressDTO;
import com.university.student_service.dto.StudentDTO;
import com.university.student_service.entity.Student;
import com.university.student_service.repository.StudentRepostiory;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final ModelMapper modelMapper;
    private final StudentRepostiory studentRepostiory;
    private final AddressClient addressClient;

    public StudentDTO addStudent(StudentDTO addStudent) {
        Student student = modelMapper.map(addStudent, Student.class);
        Student savedStudent = studentRepostiory.save(student);
        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepostiory.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
            Long addressId = student.getId(); // Assuming you have an addressId field

            // Use the Feign client to fetch the address
            AddressDTO addressDTO = addressClient.getAddressById(addressId);
            studentDTO.setAddressDTO(addressDTO);

            return studentDTO;
        } else {
            throw new EntityNotFoundException("Student not found with id: " + id);
        }
    }

    // @Override
    // public StudentDTO getStudentById(Long id) {
    //     Optional<Student> optionalStudent = studentRepostiory.findById(id);

    //     if (optionalStudent.isPresent()) {
    //         Student student = optionalStudent.get();
    //         StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
    //         Long addressId = student.getId(); // Assuming you have an addressId field

    //         // Fetch the address using WebClient
    //         Mono<AddressDTO> addressDTOMono = webClient
    //                 .get()
    //                 .uri("http://localhost:8083/api/address/getAddressById/2")
    //                 .retrieve()
    //                 .bodyToMono(AddressDTO.class)
    //                 .doOnError(e -> System.err.println("Error fetching address: " + e.getMessage())); // Error handling

    //         AddressDTO addressDTO = addressDTOMono.block(); // Block to get the result synchronously

    //         // Set addressDTO into studentDTO
    //         studentDTO.setAddressDTO(addressDTO);
    //         return studentDTO;
    //     } else {
    //         // Handle the case where the student is not found
    //         throw new EntityNotFoundException("Student not found with id: " + id);
    //     }
    // }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> students = studentRepostiory.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }
}
