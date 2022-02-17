package com.cybage.dto;

import com.cybage.model.Gender;

public class TutorDTO {

	private String name;
	private String email;
	private String password;
	private Gender gender;
	private String specialization;
	private int experience;
	
	
	public TutorDTO(String name, String email, Gender gender, String specialization, int experience) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.specialization = specialization;
		this.experience = experience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
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
	@Override
	public String toString() {
		return "TutorDTO [name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender
				+ ", specialization=" + specialization + ", experience=" + experience + "]";
	}
	
	
	
	
	
}
