package com.cybage.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cybage.dto.TutorDTO;
import com.cybage.model.ApprovalStatus;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Role;
import com.cybage.model.Student;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;
import com.cybage.repository.EnrollTechDetailsRepository;
import com.cybage.repository.StudentRepository;
import com.cybage.repository.TechnologyRepository;
import com.cybage.repository.TutorRepository;

@Service
public class TutorServiceImpl implements ITutorService {

	@Autowired
	private TutorRepository tutorRepo;
	@Autowired
	private TechnologyRepository technologyRepo;
	@Autowired
	private EnrollTechDetailsRepository enrollTechDetailsRepo;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Tutor registerTutor(TutorDTO tutor) {
		Tutor tutorNew = new Tutor(tutor.getName(), tutor.getEmail(), bcryptEncoder.encode(tutor.getPassword()),
				tutor.getGender(), Role.TUTOR, tutor.getSpecialization(), tutor.getExperience());
		tutorNew.setStatus(ApprovalStatus.PENDING);
		tutorNew.setCreatedon(LocalDateTime.now());
		return tutorRepo.save(tutorNew);
	}

	public List<Tutor> getAllTutors() {
		return tutorRepo.findAll();
	}

	@Override
	public List<Technology> getAllTutorsList(Integer studentId) {
		Student student = new Student();
		student.setId(studentId);
		List<Technology> technologies = technologyRepo.findAll().stream()
				.filter(t -> t.getBelongsToTutor().getStatus().equals(ApprovalStatus.APPROVED))
				.collect(Collectors.toList());
		List<EnrolledTechDetails> enrolledTechDetails = enrollTechDetailsRepo.findByBelongsToStudents(student);
		for (EnrolledTechDetails enrolledTechDetail : enrolledTechDetails) {
			for (Technology technology : technologies) {
				if ((enrolledTechDetail.getBelongsToStudents().getId() == studentId)
						&& (enrolledTechDetail.getBelongsToTutor().getId() == technology.getBelongsToTutor().getId())
						&& (enrolledTechDetail.getBelongsToTechnology().getTechnologyid() == technology
								.getTechnologyid())) {
					technologies.remove(technologies.indexOf(technology));
					break;
				}
			}
		}

		return technologies;
	}

	@Override
	public TutorDTO getTutorProfile(Integer tutorId) {

		return tutorRepo.getTutor(tutorId);
	}

	@Override
	public Optional<Tutor> findTutorById(Integer tutorId) {

		return tutorRepo.findById(tutorId);
	}

	@Override
	public Tutor saveTutor(Tutor tutor) {

		return tutorRepo.save(tutor);
	}

	@Override
	public List<EnrolledTechDetails> getStudentEnrollRequest(Integer tutorId) {

		return enrollTechDetailsRepo.getStudentEnrollRequest(tutorId).stream()
				.filter(student -> student.getStatus() == ApprovalStatus.PENDING).collect(Collectors.toList());
	}

	@Override
	public Optional<EnrolledTechDetails> acceptStudentEnrollment(Integer id) {
		return enrollTechDetailsRepo.findById(id).map(enroll -> {
			Tutor tutor = tutorRepo.getById(enroll.getBelongsToTutor().getId());
			tutor.setStudCount(tutor.getStudCount() + 1);
			tutorRepo.save(tutor);
			Student student = studentRepo.getById(enroll.getBelongsToStudents().getId());
			student.setTutorCount(student.getTutorCount() + 1);
			studentRepo.save(student);
			Technology tech = technologyRepo.getById(enroll.getBelongsToTechnology().getTechnologyid());
			tech.setStudCount(tech.getStudCount() + 1);
			technologyRepo.save(tech);
			enroll.setStatus(ApprovalStatus.APPROVED);
			return enrollTechDetailsRepo.save(enroll);
		});
	}

	@Override
	public Optional<EnrolledTechDetails> rejectStudentEnrollment(Integer id) {
		return enrollTechDetailsRepo.findById(id).map(enroll -> {
			enroll.setStatus(ApprovalStatus.REJECTED);
			return enrollTechDetailsRepo.save(enroll);
		});
	}

	@Override
	public List<EnrolledTechDetails> getEnrolledStudents(Integer tutorId) {
		return enrollTechDetailsRepo.getStudentEnrollRequest(tutorId).stream()
				.filter(tutor -> tutor.getStatus() == ApprovalStatus.APPROVED).collect(Collectors.toList());
	}

	@Override
	public List<EnrolledTechDetails> blockStudentEnrollment(int id) {
		EnrolledTechDetails detail = enrollTechDetailsRepo.getById(id);
		List<EnrolledTechDetails> newEnrollList = new ArrayList<>();
		List<EnrolledTechDetails> enrollList = enrollTechDetailsRepo
				.findByBelongsToStudentsAndBelongsToTutor(detail.getBelongsToStudents(), detail.getBelongsToTutor());
		enrollList.stream().forEach(enroll -> {
			if (enroll.getStatus().equals(ApprovalStatus.APPROVED)) {
				Tutor tutor = tutorRepo.getById(enroll.getBelongsToTutor().getId());
				tutor.setStudCount(tutor.getStudCount() - 1);
				tutorRepo.save(tutor);
				Student student = studentRepo.getById(enroll.getBelongsToStudents().getId());
				student.setTutorCount(student.getTutorCount() - 1);
				studentRepo.save(student);
				Technology tech = technologyRepo.getById(enroll.getBelongsToTechnology().getTechnologyid());
				tech.setStudCount(tech.getStudCount() - 1);
				technologyRepo.save(tech);
			}
			enroll.setStatus(ApprovalStatus.BLOCKED);
			newEnrollList.add(enrollTechDetailsRepo.save(enroll));
		});
		return newEnrollList;

	}

}