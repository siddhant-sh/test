package com.cybage.dto;

public class TutorCountDTO {

	private int tutorId;
	private Long count;
	
	public TutorCountDTO(int tutorId, Long count) {
		super();
		this.tutorId = tutorId;
		this.count = count;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
}
