package com.cybage.dto;

public class TechnologyDTO {
	private String technologyname;
	private int tutorId;

	public TechnologyDTO(String technologyname, int tutorId) {
		super();
		this.technologyname = technologyname;
		this.tutorId = tutorId;
	}

	public String getTechnologyname() {
		return technologyname;
	}

	public void setTechnologyname(String technologyname) {
		this.technologyname = technologyname;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

}
