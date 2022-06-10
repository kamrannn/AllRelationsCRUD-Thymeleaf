package com.noxzyge.springbootapp.service;

import com.noxzyge.springbootapp.model.RollNumber;
import com.noxzyge.springbootapp.repository.RollNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RollNumberService {
    @Autowired
    RollNumberRepository rollNumberRepository;

    public List<RollNumber> getAllRollNumbers() {
        return rollNumberRepository.findAll();
    }

    public RollNumber saveRollNumber(RollNumber rollNumber) {
        return rollNumberRepository.save(rollNumber);
    }

    public void deleteRollNumber(Integer rollNumberId) {
        Optional<RollNumber> rollNumber = rollNumberRepository.findById(rollNumberId);
        if (rollNumber.isPresent()) {
            rollNumberRepository.delete(rollNumber.get());
        } else {
            throw new RuntimeException("There is no rollNumber Against this rollNumber ID");
        }
    }

    public RollNumber getRollNumberById(Integer rollNumberId) {
        Optional<RollNumber> rollNumber = rollNumberRepository.findById(rollNumberId);
        if (rollNumber.isPresent()) {
            return rollNumber.get();
        } else {
            throw new RuntimeException("RollNumber not found");
        }
    }
}
