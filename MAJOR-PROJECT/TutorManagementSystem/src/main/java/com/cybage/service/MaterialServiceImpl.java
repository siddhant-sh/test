package com.cybage.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dto.MaterialDTO;
import com.cybage.dto.TutorCountDTO;
import com.cybage.model.ApprovalStatus;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Material;
import com.cybage.model.Student;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;
import com.cybage.repository.EnrollTechDetailsRepository;
import com.cybage.repository.MaterialRepository;
import com.cybage.repository.TechnologyRepository;

@Service
public class MaterialServiceImpl implements IMaterialService {

	@Autowired(required = true)
	private MaterialRepository materialRepo;

	@Autowired(required = true)
	private EnrollTechDetailsRepository enrollRepo;

	@Autowired(required = true)
	private TechnologyRepository techRepo;

	@Override
	public Material addMaterial(MaterialDTO materialDto) {
		Technology tech = techRepo.getById(materialDto.getTechnologyId());
		if (tech.getBelongsToTutor().getId() == materialDto.getTutorId()) {
			Material material = new Material();
			Tutor tutor = new Tutor();
			tutor.setId(materialDto.getTutorId());
			Technology technology = new Technology();
			technology.setTechnologyid(materialDto.getTechnologyId());
			material.setBelongsToTutor(tutor);
			material.setBelongsTechnology(technology);
			material.setFileName(materialDto.getFileName());
			material.setUploadedon(LocalDateTime.now());
			try {
				String fileName = materialDto.getFile().getOriginalFilename();
				if (fileName != null) {
					String[] fileFrags = fileName.split("\\.");
					material.setFileType(fileFrags[fileFrags.length - 1]);
				} else
					material.setFileType(materialDto.getFile().getContentType());
				material.setFileData(materialDto.getFile().getBytes());
				material.setFileSize(this.bytesIntoHumanReadable(materialDto.getFile().getSize()));
			} catch (IOException e) {
				return null;
			}
			return materialRepo.save(material);
		}
		return new Material();

	}

	private String bytesIntoHumanReadable(long bytes) {
		long kilobyte = 1024;
		long megabyte = kilobyte * 1024;
		long gigabyte = megabyte * 1024;
		long terabyte = gigabyte * 1024;

		if ((bytes >= 0) && (bytes < kilobyte)) {
			return bytes + " B";

		} else if ((bytes >= kilobyte) && (bytes < megabyte)) {
			return (bytes / kilobyte) + " KB";

		} else if ((bytes >= megabyte) && (bytes < gigabyte)) {
			return (bytes / megabyte) + " MB";

		} else if ((bytes >= gigabyte) && (bytes < terabyte)) {
			return (bytes / gigabyte) + " GB";

		} else if (bytes >= terabyte) {
			return (bytes / terabyte) + " TB";

		} else {
			return bytes + " Bytes";
		}
	}

	@Override
	public List<Material> getAllMaterial(int technologyId) {
		Technology technology = new Technology();
		technology.setTechnologyid(technologyId);
		return materialRepo.getByBelongsTechnology(technology);
	}

	@Override
	public Material downloadFile(int materialId) {
		return materialRepo.getById(materialId);
	}

	@Override
	public boolean deleteMaterial(int materialId) {
		Material material = materialRepo.getById(materialId);
		if (material.getFileName() != null) {
			materialRepo.delete(material);
			return true;
		} else
			return false;
	}

	@Override
	public Material downloadFileforStudent(int materialId) {
		Material material = materialRepo.getById(materialId);
		material.setDownloadCount(material.getDownloadCount() + 1);
		materialRepo.save(material);
		return material;
	}

	@Override
	public List<Material> getMaterialForStudent(int studentId, int technologyId) {
		Student student = new Student();
		student.setId(studentId);
		Technology technology = new Technology();
		technology.setTechnologyid(technologyId);
		EnrolledTechDetails enroll = enrollRepo.getByBelongsToStudentsAndBelongsToTechnology(student, technology);
		if (enroll != null) {
			if (enroll.getStatus() == ApprovalStatus.APPROVED)
				return materialRepo.getByBelongsTechnology(technology);
			else
				return new ArrayList<>();
		}

		else
			return new ArrayList<>();
	}

	@Override
	public List<TutorCountDTO> getMaterialCountforTutor() {
		return materialRepo.findMaterialCount();
	}

	@Override
	public List<Material> getAllMaterialforTutor(int tutorId, int technologyId) {
		Tutor tutor = new Tutor();
		tutor.setId(tutorId);
		Technology tech = new Technology();
		tech.setTechnologyid(technologyId);
		Technology technology = techRepo.getByTechnologyidAndBelongsToTutor(technologyId, tutor);
		if (technology != null) {
			if (technology.getBelongsToTutor().getId() == tutorId)
				return materialRepo.getByBelongsTechnology(tech);
			else
				return new ArrayList<>();
		} else
			return new ArrayList<>();
	}

	@Override
	public List<TutorCountDTO> getMaterialDownloadCountforTutor() {
		return materialRepo.findDownloadCount();
	}
}
