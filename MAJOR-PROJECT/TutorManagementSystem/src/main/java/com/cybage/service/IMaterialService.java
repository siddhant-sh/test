package com.cybage.service;

import java.util.List;

import com.cybage.dto.MaterialDTO;
import com.cybage.dto.TutorCountDTO;
import com.cybage.model.Material;

public interface IMaterialService {

	public Material addMaterial(MaterialDTO materialDto);

	public List<Material> getAllMaterial(int tutorId);

	public Material downloadFile(int materialId);

	public boolean deleteMaterial(int materialId);

	public Material downloadFileforStudent(int materialId);

	public List<Material> getMaterialForStudent(int studentId, int technologyId);

	public List<TutorCountDTO> getMaterialCountforTutor();

	public List<Material> getAllMaterialforTutor(int tutorId, int technologyId);

	public List<TutorCountDTO> getMaterialDownloadCountforTutor();

}
