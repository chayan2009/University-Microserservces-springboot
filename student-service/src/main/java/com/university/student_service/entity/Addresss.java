package com.university.student_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Addresss {
    
    private Long id;
    private String street;
    private String city;
    private String pincode;

}
