package com.noxzyge.springbootapp.service;

import com.noxzyge.springbootapp.model.Address;
import com.noxzyge.springbootapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;


    public List<Address> getAllAddresss() {
        return addressRepository.findAll();
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
        } else {
            throw new RuntimeException("There is no address Against this address ID");
        }
    }

    public Address getAddressById(Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            return address.get();
        } else {
            throw new RuntimeException("Address not found");
        }
    }
}
