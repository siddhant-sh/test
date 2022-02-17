package com.cybage.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.dto.TutorDTO;
import com.cybage.model.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer>{
	
	@Query(value = "SELECT new com.cybage.dto.TutorDTO(t.username,t.email,t.gender,t.specialization,t.experience) FROM Tutor t WHERE t.id=:tutorId")
	TutorDTO getTutor(Integer tutorId);

}
