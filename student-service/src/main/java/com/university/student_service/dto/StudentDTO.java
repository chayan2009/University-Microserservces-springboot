package com.university.student_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;
    private String name;
    private String email;
    private String phonenumber;
    @JsonProperty("address") // Change the name to "address" if needed
    private AddressDTO addressDTO; // Add this line

}
