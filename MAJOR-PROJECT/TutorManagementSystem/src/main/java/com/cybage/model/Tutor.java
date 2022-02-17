package com.cybage.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tutor extends UserDao {
	private String specialization;
	private int experience;
	@OneToMany(mappedBy = "belongsToTutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Technology> technologies = new ArrayList<>();
	@OneToMany(mappedBy = "belongsToTutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Material> materials = new ArrayList<>();
	@OneToMany(mappedBy = "belongsToTutor", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EnrolledTechDetails> studentList = new ArrayList<>();
	private int studCount;

	public Tutor() {
		super();
	}

	public Tutor(int id, String username, String email, Gender gender, Role role, ApprovalStatus status,
			LocalDateTime createdon, String specialization, int experience) {
		super(id, username, email, gender, role, status, createdon);
		this.specialization = specialization;
		this.experience = experience;
	}

	public Tutor(String username, String email, String password, Gender gender, Role role, String specialization,
			int experience) {
		super(username, email, password, gender, role);
		this.specialization = specialization;
		this.experience = experience;
	}

	public Tutor(String username, String email, String specialization, int experience) {
		super(username, email);
		this.specialization = specialization;
		this.experience = experience;
	}

	public Tutor(Integer tutorid) {
		this.setId(tutorid);
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public List<EnrolledTechDetails> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<EnrolledTechDetails> studentList) {
		this.studentList = studentList;
	}

	public int getStudCount() {
		return studCount;
	}

	public void setStudCount(int studCount) {
		this.studCount = studCount;
	}

}