package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
