package com.noxzyge.springbootapp.controller;

import com.noxzyge.springbootapp.model.Address;
import com.noxzyge.springbootapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;


    @GetMapping("/all")
    public List<Address> addressList() {
        return addressService.getAllAddresss();
    }

    @GetMapping("/getById")
    public Address addressList(@RequestParam(name = "id") Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/new")
    public Address addAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("/update")
    public Address updateAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @DeleteMapping("/delete")
    public String deleteAddress(@RequestParam(name = "id") Integer id) {
        addressService.deleteAddress(id);
        return "Address is successfully deleted";
    }
}
