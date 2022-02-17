package com.cybage.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int respondentid;
	private String respondentname;
	private int receiverid;
	private String receivername;
	private double rating;
	private LocalDateTime givenon;

	public Feedback(int respondentid, String respondentname, int receiverid, String receivername,
			double rating) {
		this.respondentid = respondentid;
		this.respondentname = respondentname;
		this.receiverid = receiverid;
		this.receivername = receivername;
		this.rating = rating;
	}

	public Feedback() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDateTime getGivenon() {
		return givenon;
	}

	public void setGivenon(LocalDateTime givenon) {
		this.givenon = givenon;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", respondentid=" + respondentid + ", respondentname=" + respondentname
				+ ", receiverid=" + receiverid + ", receivername=" + receivername + ", rating=" + rating + "]";
	}

}
