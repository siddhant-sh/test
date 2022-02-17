package com.cybage.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cybage.dto.EnrolledTechDetailsDTO;
import com.cybage.dto.StudentDTO;
import com.cybage.model.ApprovalStatus;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Role;
import com.cybage.model.Student;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;
import com.cybage.repository.EnrollTechDetailsRepository;
import com.cybage.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private EnrollTechDetailsRepository enrollTechDetailsRepo;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public Student registerStudent(StudentDTO student) {
		Student studentNew = new Student(student.getName(), student.getEmail(),
				bcryptEncoder.encode(student.getPassword()), student.getGender(), Role.STUDENT,
				student.getQualification());
		studentNew.setStatus(ApprovalStatus.PENDING);
		studentNew.setCreatedon(LocalDateTime.now());
		return studentRepo.save(studentNew);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public EnrolledTechDetails enrollToTutor(EnrolledTechDetailsDTO enrollTechDetails) {
		EnrolledTechDetails enrollRequest = new EnrolledTechDetails();
		Student student = new Student();
		student.setId(enrollTechDetails.getStudentId());
		Tutor tutor = new Tutor();
		tutor.setId(enrollTechDetails.getTutorId());
		Technology technology = new Technology();
		technology.setTechnologyid(enrollTechDetails.getTechnologyId());
		enrollRequest.setBelongsToStudents(student);
		enrollRequest.setBelongsToTutor(tutor);
		enrollRequest.setBelongsToTechnology(technology);
		enrollRequest.setCreatedon(LocalDateTime.now());
		enrollRequest.setStatus(ApprovalStatus.PENDING);
		return enrollTechDetailsRepo.save(enrollRequest);
	}

	@Override
	public Optional<Student> findStudentById(Integer studentId) {
		return studentRepo.findById(studentId);
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

}