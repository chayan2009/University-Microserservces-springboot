package com.university.address_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.address_service.dto.AddressDTO;
import com.university.address_service.service.AddressService;
import com.university.address_service.utils.ApiResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/address")
public class AddressController {
    
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<AddressDTO>> addCourse(@RequestBody AddressDTO addressDTO) {
        AddressDTO addedAddress = addressService.addAddress(addressDTO);
        ApiResponse<AddressDTO> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "Address created successfully",
                addedAddress);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/allAddress")
    public ResponseEntity<ApiResponse<List<AddressDTO>>> getAllAddress() {
        List<AddressDTO> addressList = addressService.getAllAddress();
        ApiResponse<List<AddressDTO>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Address retrieved successfully",
                addressList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("getAddressById/{id}")
    public ResponseEntity<ApiResponse<AddressDTO>> getCourseById(@PathVariable("id") Long courseId) {
        AddressDTO addressDto = addressService.getAddressById(courseId);
        ApiResponse<AddressDTO> response = new ApiResponse<>(
            HttpStatus.OK.value(),
            "Address retrieved successfully",
            addressDto
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
