package com.cybage.dto;

import org.springframework.web.multipart.MultipartFile;

public class MaterialDTO {
	private String fileName;
	private int technologyId;
	private int tutorId;
	private MultipartFile file;

	public MaterialDTO(String fileName, int technologyId, int tutorId, MultipartFile file) {
		super();
		this.fileName = fileName;
		this.technologyId = technologyId;
		this.tutorId = tutorId;
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "MaterialDTO [fileName=" + fileName + ", technologyId=" + technologyId + ", tutorId=" + tutorId + "]";
	}

}
