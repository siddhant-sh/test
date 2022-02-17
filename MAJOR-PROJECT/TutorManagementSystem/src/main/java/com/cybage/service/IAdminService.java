package com.cybage.service;


import java.util.List;
import java.util.Optional;

import com.cybage.model.Student;
import com.cybage.model.Tutor;

public interface IAdminService {
	public List<Tutor> approvedTutors();

	public Optional<Tutor> blockTutor(int id);

	public Optional<Tutor> acceptTutor(int id);

	public Optional<Tutor> rejectTutor(int id);
	
	public List<Tutor> getAllTutorForApproval();
	
	public List<Tutor> getAllBlockedTutor();
	
	public List<Tutor> getAllRejectedTutor();

	// Student Methods
	public Optional<Student> blockStudent(int id);

	public List<Student> approvedStudent();

	public Optional<Student> acceptStudent(int id);

	public Optional<Student> rejectStudent(int id);
	
	public List<Student> getAllStudentsForApproval();
	
	
	public List<Student> getAllRejectedStudent();
	public List<Student> getAllBlockedStudent();
}
