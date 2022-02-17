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
public class Student extends UserDao {
	private String qualification;

	@OneToMany(mappedBy = "belongsToStudents", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EnrolledTechDetails> tutorList = new ArrayList<>();
	private int tutorCount;

	public Student() {
		super();
	}

	public Student(int id, String username, String email, Gender gender, Role role, ApprovalStatus status,
			LocalDateTime createdon, String qualification) {
		super(id, username, email, gender, role, status, createdon);
		this.qualification = qualification;
	}

	public Student(String username, String email, String password, Gender gender, Role role, String qualification) {
		super(username, email, password, gender, role);
		this.qualification = qualification;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public List<EnrolledTechDetails> getTutorList() {
		return tutorList;
	}

	public void setTutorList(List<EnrolledTechDetails> tutorList) {
		this.tutorList = tutorList;
	}

	public int getTutorCount() {
		return tutorCount;
	}

	public void setTutorCount(int tutorCount) {
		this.tutorCount = tutorCount;
	}

	@Override
	public String toString() {
		return "Student [qualification=" + qualification + "]";
	}

}
