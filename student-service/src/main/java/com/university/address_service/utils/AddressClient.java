package com.university.address_service.utils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.university.student_service.dto.AddressDTO;

@FeignClient(name = "address-service", url = "http://localhost:8083/api/address")
public interface AddressClient {
    @GetMapping("/getAddressById/{id}")
    AddressDTO getAddressById(@PathVariable("id") Long id);
}

