package com.cybage.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Material {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int materialid;
	private String fileName;
	private String fileType;
	@Lob
	private byte[] fileData;
	private String fileSize;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tutorid", nullable = false)
	@JsonIgnore
	private Tutor belongsToTutor;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime uploadedon;
	private int downloadCount;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "technologyid", nullable = false)
	private Technology belongsTechnology;
	
	
	public Material() {
		
	}

	public Material(int materialid, String fileName, String fileType, byte[] fileData, String fileSize,
			LocalDateTime uploadedon, Technology belongsTechnology) {
		super();
		this.materialid = materialid;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
		this.fileSize = fileSize;
		this.uploadedon = uploadedon;
		this.belongsTechnology = belongsTechnology;
	}

	

	public int getMaterialid() {
		return materialid;
	}

	public void setMaterialid(int materialid) {
		this.materialid = materialid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Tutor getBelongsToTutor() {
		return belongsToTutor;
	}

	public void setBelongsToTutor(Tutor belongsToTutor) {
		this.belongsToTutor = belongsToTutor;
	}

	public LocalDateTime getUploadedon() {
		return uploadedon;
	}

	public void setUploadedon(LocalDateTime uploadedon) {
		this.uploadedon = uploadedon;
	}

	public Technology getBelongsTechnology() {
		return belongsTechnology;
	}

	public void setBelongsTechnology(Technology belongsTechnology) {
		this.belongsTechnology = belongsTechnology;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	

}
