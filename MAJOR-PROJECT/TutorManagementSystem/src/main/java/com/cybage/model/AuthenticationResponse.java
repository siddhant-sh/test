package com.cybage.model;

public class AuthenticationResponse {

	private String token;
	private int id;
	private String username;
	private String role;
	private ApprovalStatus status;
	
	public AuthenticationResponse()
	{
		
	}

	
	public AuthenticationResponse(String token, int id, String username, String role,ApprovalStatus status) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.role = role;
		this.status = status;
	}


	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public ApprovalStatus getStatus() {
		return status;
	}


	public void setStatus(ApprovalStatus status) {
		this.status = status;
	}
	
	
	
}
