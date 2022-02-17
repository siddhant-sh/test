package com.cybage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int technologyid;
	private String technologyname;
	private double rating;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tutorid", nullable = false)
	private Tutor belongsToTutor;
	@OneToMany(mappedBy = "belongsTechnology", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Material> materials = new ArrayList<>();
	@OneToMany(mappedBy = "belongsToTechnology", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EnrolledTechDetails> technologyList = new ArrayList<>();
	private int studCount;

	public Technology() {

	}

	public Technology(int technologyid, String technologyname, double rating) {
		super();
		this.technologyid = technologyid;
		this.technologyname = technologyname;
		this.rating = rating;
	}

	public Technology(Integer technologyid2) {
		this.technologyid = technologyid2;
	}

	public Technology(String technologyname2) {
		this.technologyname = technologyname2;
	}

	public int getTechnologyid() {
		return technologyid;
	}

	public void setTechnologyid(int technologyid) {
		this.technologyid = technologyid;
	}

	public String getTechnologyname() {
		return technologyname;
	}

	public void setTechnologyname(String technologyname) {
		this.technologyname = technologyname;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Tutor getBelongsToTutor() {
		return belongsToTutor;
	}

	public void setBelongsToTutor(Tutor belongsToTutor) {
		this.belongsToTutor = belongsToTutor;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public List<EnrolledTechDetails> getTechnologyList() {
		return technologyList;
	}

	public void setTechnologyList(List<EnrolledTechDetails> technologyList) {
		this.technologyList = technologyList;
	}

	public int getStudCount() {
		return studCount;
	}

	public void setStudCount(int studCount) {
		this.studCount = studCount;
	}

}
