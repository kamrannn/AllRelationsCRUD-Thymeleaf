package com.noxzyge.springbootapp.controller;

import com.noxzyge.springbootapp.model.RollNumber;
import com.noxzyge.springbootapp.service.RollNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rollNumber")
public class RollNumberController {
    @Autowired
    RollNumberService rollNumberService;


    @GetMapping("/all")
    public List<RollNumber> rollNumberList() {
        return rollNumberService.getAllRollNumbers();
    }

    @GetMapping("/getById")
    public RollNumber rollNumberList(@RequestParam(name = "id") Integer id) {
        return rollNumberService.getRollNumberById(id);
    }

    @PostMapping("/new")
    public RollNumber addRollNumber(@RequestBody RollNumber rollNumber) {
        return rollNumberService.saveRollNumber(rollNumber);
    }

    @PutMapping("/update")
    public RollNumber updateRollNumber(@RequestBody RollNumber rollNumber) {
        return rollNumberService.saveRollNumber(rollNumber);
    }

    @DeleteMapping("/delete")
    public String deleteRollNumber(@RequestParam(name = "id") Integer id) {
        rollNumberService.deleteRollNumber(id);
        return "RollNumber is successfully deleted";
    }

}
