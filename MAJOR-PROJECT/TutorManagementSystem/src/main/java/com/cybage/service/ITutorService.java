package com.cybage.service;

import java.util.List;
import java.util.Optional;

import com.cybage.dto.TutorDTO;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;

public interface ITutorService {

	public Tutor registerTutor(TutorDTO tutor);
	public List<Tutor> getAllTutors();
	public List<Technology> getAllTutorsList(Integer studentId);
	public TutorDTO getTutorProfile(Integer tutorId);
	public Optional<Tutor>  findTutorById(Integer tutorId);
	public Tutor saveTutor(Tutor tutor);
	public List<EnrolledTechDetails> getStudentEnrollRequest(Integer tutorId);
	public Optional<EnrolledTechDetails> acceptStudentEnrollment(Integer id);
	public Optional<EnrolledTechDetails>  rejectStudentEnrollment(Integer id);
	public List<EnrolledTechDetails>  getEnrolledStudents(Integer tutorId);
	public List<EnrolledTechDetails> blockStudentEnrollment(int id);

}
