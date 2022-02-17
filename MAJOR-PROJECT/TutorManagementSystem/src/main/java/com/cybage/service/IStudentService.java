package com.cybage.service;

import java.util.List;
import java.util.Optional;

import com.cybage.dto.EnrolledTechDetailsDTO;
import com.cybage.dto.StudentDTO;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Student;

public interface IStudentService {

	public Student registerStudent(StudentDTO student);

	public EnrolledTechDetails enrollToTutor(EnrolledTechDetailsDTO enrollTechDetails);

	public Optional<Student> findStudentById(Integer studentId);

	public Student saveStudent(Student student);

	List<Student> getAllStudents();

}