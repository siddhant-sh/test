package com.cybage.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	@JsonIgnore
	private Role role;
	@Enumerated(EnumType.STRING)
	private ApprovalStatus status;
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdon;

	public UserDao() {
	}

	public UserDao(String username, String email, String password, Gender gender,Role role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role=role;
		
	}

	
	
	public UserDao(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public UserDao(int id, String username, String email, String password, Gender gender, Role role,
			ApprovalStatus status, LocalDateTime createdon) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.status = status;
		this.createdon = createdon;
	}

	
	public UserDao(int id, String username, String email,  Gender gender, Role role,
			ApprovalStatus status, LocalDateTime createdon) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.role=role;
		this.status = status;
		this.createdon = createdon;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ApprovalStatus getStatus() {
		return status;
	}

	public void setStatus(ApprovalStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", role=" + role + "]";
	}

	
}
