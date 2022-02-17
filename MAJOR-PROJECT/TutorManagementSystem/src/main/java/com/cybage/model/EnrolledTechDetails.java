package com.cybage.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class EnrolledTechDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollid;
	@Enumerated(EnumType.STRING)
	private ApprovalStatus status;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "studentid", nullable = false)
	private Student belongsToStudents;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tutorsid", nullable = false)
	private Tutor belongsToTutor;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "technologyid", nullable = false)
	private Technology belongsToTechnology;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdon;
	private double techRating;

	public EnrolledTechDetails(int enrollid, ApprovalStatus status, Student belongsToStudents, Tutor belongsToTutor,
			LocalDateTime createdon) {
		super();
		this.enrollid = enrollid;
		this.status = status;
		this.belongsToStudents = belongsToStudents;
		this.belongsToTutor = belongsToTutor;
		this.createdon = createdon;

	}

	public EnrolledTechDetails(int enrollid, ApprovalStatus status, Student belongsToStudents, Tutor belongsToTutor,
			Technology belongsToTechnology, LocalDateTime createdon) {
		super();
		this.enrollid = enrollid;
		this.status = status;
		this.belongsToStudents = belongsToStudents;
		this.belongsToTutor = belongsToTutor;
		this.belongsToTechnology = belongsToTechnology;
		this.createdon = createdon;
	}

	public EnrolledTechDetails() {

	}

	public int getEnrollid() {
		return enrollid;
	}

	public void setEnrollid(int enrollid) {
		this.enrollid = enrollid;
	}

	public ApprovalStatus getStatus() {
		return status;
	}

	public void setStatus(ApprovalStatus status) {
		this.status = status;
	}

	public Student getBelongsToStudents() {
		return belongsToStudents;
	}

	public void setBelongsToStudents(Student belongsToStudents) {
		this.belongsToStudents = belongsToStudents;
	}

	public Tutor getBelongsToTutor() {
		return belongsToTutor;
	}

	public void setBelongsToTutor(Tutor belongsToTutor) {
		this.belongsToTutor = belongsToTutor;
	}

	public LocalDateTime getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	public Technology getBelongsToTechnology() {
		return belongsToTechnology;
	}

	public void setBelongsToTechnology(Technology belongsToTechnology) {
		this.belongsToTechnology = belongsToTechnology;
	}

	public double getTechRating() {
		return techRating;
	}

	public void setTechRating(double techRating) {
		this.techRating = techRating;
	}

	@Override
	public String toString() {
		return "EnrolledTechDetails [enrollid=" + enrollid + ", status=" + status + ", belongsToStudents="
				+ belongsToStudents + ", belongsToTutor=" + belongsToTutor + ", belongsToTechnology="
				+ belongsToTechnology + ", createdon=" + createdon + "]";
	}

}
