package com.university.address_service.service;

import java.util.List;

import com.university.address_service.dto.AddressDTO;

public interface AddressService {
    
    AddressDTO addAddress(AddressDTO addressDTO);
    AddressDTO getAddressById(Long id);
    List<AddressDTO> getAllAddress();
    
}
