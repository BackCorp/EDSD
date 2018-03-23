package com.edsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edsd.model.PrimesEdsd;

public interface PrimesEdsdRepository extends JpaRepository<PrimesEdsd, Integer>, CrudRepository<PrimesEdsd, Integer> {

}
