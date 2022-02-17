package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.dto.TutorCountDTO;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

	public List<Technology> findByBelongsToTutor(Tutor tutor);

	@Query("select new com.cybage.dto.TutorCountDTO(t.belongsToTutor.id as tutorId,count(t.belongsToTutor) as count) from Technology t group by t.belongsToTutor")
	public List<TutorCountDTO> findTechnologyCount();

	public Technology getByTechnologyidAndBelongsToTutor(int technologyId, Tutor tutor);
}
