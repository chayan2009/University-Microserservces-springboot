package com.university.address_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.university.address_service.dto.AddressDTO;
import com.university.address_service.entity.Address;
import com.university.address_service.repository.AddressRepostiory;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{


    private ModelMapper modelMapper;

    private AddressRepostiory addressRepostiory;

    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {

        Address address=modelMapper.map(addressDTO, Address.class);

        Address saveAddress=addressRepostiory.save(address);

        return modelMapper.map(saveAddress,AddressDTO.class);

    }

    @Override
    public AddressDTO getAddressById(Long id) {
        Address address = addressRepostiory.findById(id).orElse(null);
        if (address != null) {
            return modelMapper.map(address, AddressDTO.class);
        }
        return null;
    }

    @Override
    public List<AddressDTO> getAllAddress() {
       List<Address> addresses = addressRepostiory.findAll();

        return addresses.stream().map((address) -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }
    
}
