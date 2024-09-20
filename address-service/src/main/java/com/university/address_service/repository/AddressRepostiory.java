package com.university.address_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.address_service.entity.Address;

public interface AddressRepostiory extends JpaRepository<Address,Long>{
    
}
