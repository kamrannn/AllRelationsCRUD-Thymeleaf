package com.noxzyge.springbootapp.repository;

import com.noxzyge.springbootapp.model.RollNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollNumberRepository extends JpaRepository<RollNumber, Integer> {
}
