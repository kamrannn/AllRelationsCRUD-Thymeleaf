package com.noxzyge.springbootapp.repository;

import com.noxzyge.springbootapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Transactional
    void deleteAddressesByStudentId(Integer studentId);
}
