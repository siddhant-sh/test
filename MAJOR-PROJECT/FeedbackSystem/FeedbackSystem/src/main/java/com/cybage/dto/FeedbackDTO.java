package com.cybage.dto;

public class FeedbackDTO {

	private int respondentid;
	private String respondentname;
	private int receiverid;
	private String receivername;
	private double rating;

	public FeedbackDTO( String respondentname, int receiverid, String receivername, double rating) {
		this.respondentname = respondentname;
		this.receiverid = receiverid;
		this.receivername = receivername;
		this.rating = rating;
	}

	public int getRespondentid() {
		return respondentid;
	}

	public void setRespondentid(int respondentid) {
		this.respondentid = respondentid;
	}

	public String getRespondentname() {
		return respondentname;
	}

	public void setRespondentname(String respondentname) {
		this.respondentname = respondentname;
	}

	public int getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
