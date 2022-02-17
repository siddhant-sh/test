package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.dto.TutorCountDTO;
import com.cybage.model.Material;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

	public List<Material> getByBelongsTechnology(Technology technology);

	public Material findByBelongsToTutor(Tutor tutorid);

	public Material findByMaterialid(Integer materialId);

	public List<Material> getByBelongsToTutor(Tutor tutor);

	@Query("select new com.cybage.dto.TutorCountDTO(m.belongsToTutor.id as tutorId,count(m.belongsToTutor) as count) from Material m group by m.belongsToTutor")
	public List<TutorCountDTO> findMaterialCount();
	
	@Query("select new com.cybage.dto.TutorCountDTO(m.belongsToTutor.id as tutorId,sum(m.downloadCount) as count) from Material m group by m.belongsToTutor")
	public List<TutorCountDTO> findDownloadCount();

}