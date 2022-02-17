package com.cybage.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.ApprovalStatus;
import com.cybage.model.Student;
import com.cybage.model.Tutor;
import com.cybage.repository.StudentRepository;
import com.cybage.repository.TutorRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	
	@Autowired
	private TutorRepository tutorRepo;
	
	
	@Autowired
	private StudentRepository studentRepo;
	
	

	public List<Tutor> approvedTutors() {
		return tutorRepo.findAll().stream().filter(tutor -> tutor.getStatus() == ApprovalStatus.APPROVED)
				.collect(Collectors.toList());
	}

	public Optional<Tutor> blockTutor(int id) {
		return tutorRepo.findById(id).map(tutor -> {
			tutor.setStatus(ApprovalStatus.BLOCKED);
			return tutorRepo.save(tutor);
		});
	}

	public Optional<Tutor> acceptTutor(int id) {
		return tutorRepo.findById(id).map(tutor -> {
			tutor.setStatus(ApprovalStatus.APPROVED);
			return tutorRepo.save(tutor);
		});
	}

	public Optional<Tutor> rejectTutor(int id) {
		return tutorRepo.findById(id).map(tutor -> {
			tutor.setStatus(ApprovalStatus.REJECTED);
			return tutorRepo.save(tutor);
		});
	}

	public List<Tutor> getAllTutorForApproval(){
		return tutorRepo.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.PENDING)
				.collect(Collectors.toList());
	}
	
	public List<Tutor> getAllBlockedTutor(){
		
		return tutorRepo.findAll().stream().filter(tutor -> tutor.getStatus() == ApprovalStatus.BLOCKED)
				.collect(Collectors.toList());
	}
	
	public List<Tutor> getAllRejectedTutor(){
		return tutorRepo.findAll().stream().filter(tutor -> tutor.getStatus() == ApprovalStatus.REJECTED)
				.collect(Collectors.toList());
	}
	
	// Student methods implementation

	
	public List<Student> getAllStudentsForApproval(){
		
		return studentRepo.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.PENDING)
				.collect(Collectors.toList());
	}

	public Optional<Student> blockStudent(int id) {
		return studentRepo.findById(id).map(student -> {
			student.setStatus(ApprovalStatus.BLOCKED);
			return studentRepo.save(student);
		});
	}

	public List<Student> approvedStudent() {
		return studentRepo.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.APPROVED)
				.collect(Collectors.toList());
	}

	public Optional<Student> acceptStudent(int id) {
		return studentRepo.findById(id).map(student -> {
			student.setStatus(ApprovalStatus.APPROVED);
			return studentRepo.save(student);
		});
	}

	public Optional<Student> rejectStudent(int id) {
		return studentRepo.findById(id).map(student -> {
			student.setStatus(ApprovalStatus.REJECTED);
			return studentRepo.save(student);
		});

	}

	@Override
	public List<Student> getAllRejectedStudent() {

		return studentRepo.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.REJECTED)
				.collect(Collectors.toList());
		}

	@Override
	public List<Student> getAllBlockedStudent() {
	
		return studentRepo.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.BLOCKED)
				.collect(Collectors.toList());
	}

}