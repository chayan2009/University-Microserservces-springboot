package com.university.student_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.address_service.utils.ApiResponse;
import com.university.student_service.dto.StudentDTO;
import com.university.student_service.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/student")
public class StudentController {
    
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<StudentDTO>> addCourse(@RequestBody StudentDTO studentDto) {
        StudentDTO addStudent = studentService.addStudent(studentDto);
        ApiResponse<StudentDTO> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "Student created successfully",
                addStudent);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/allStudent")
    public ResponseEntity<ApiResponse<List<StudentDTO>>> getAllAddress() {
        List<StudentDTO> addressList = studentService.getAllStudent();
        ApiResponse<List<StudentDTO>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Student retrieved successfully",
                addressList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("getStudentById/{id}")
    public ResponseEntity<ApiResponse<StudentDTO>> getCourseById(@PathVariable("id") Long courseId) {
        StudentDTO addressDto = studentService.getStudentById(courseId);
        ApiResponse<StudentDTO> response = new ApiResponse<>(
            HttpStatus.OK.value(),
            "Student retrieved successfully",
            addressDto
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
