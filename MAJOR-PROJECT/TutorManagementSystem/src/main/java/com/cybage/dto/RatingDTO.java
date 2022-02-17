package com.cybage.dto;

public class RatingDTO {

	private int enrollId;
	private float rating;

	public RatingDTO(int enrollId, float rating) {
		super();
		this.enrollId = enrollId;
		this.rating = rating;
	}

	public int getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(int enrollId) {
		this.enrollId = enrollId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
