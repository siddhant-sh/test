package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dto.TutorCountDTO;
import com.cybage.model.Student;
import com.cybage.model.Tutor;
import com.cybage.service.IAdminService;
import com.cybage.service.IMaterialService;
import com.cybage.service.ITechnologyService;
import com.cybage.service.ITutorService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired(required = true)
	private ITutorService tutorService;

	@Autowired(required = true)
	private IAdminService adminService;

	@Autowired
	private ITechnologyService techService;

	@Autowired
	private IMaterialService materialService;

	@GetMapping("/tutors")
	public ResponseEntity<List<Tutor>> tutorList() {
		try {
			List<Tutor> tutorList = tutorService.getAllTutors();
			if (tutorList != null) {
				logger.info("Inside get tutorlist for admin");
				return ResponseEntity.ok().body(tutorList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/approvedtutors")
	public ResponseEntity<List<Tutor>> approvedTutors() {
		try {
			List<Tutor> approvedTutorList = adminService.approvedTutors();
			if (approvedTutorList != null) {
				logger.info("Inside get approved tutorlist for admin");
				return ResponseEntity.ok().body(approvedTutorList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/blocktutor/{id}")
	public ResponseEntity<Optional<Tutor>> blockTutor(@PathVariable("id") int id) {
		try {
			Optional<Tutor> blockedTutor = adminService.blockTutor(id);
			if (blockedTutor.isPresent()) {
				logger.info("Block Tutor by Admin");
				return ResponseEntity.ok().body(blockedTutor);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/accepttutor/{id}")
	public ResponseEntity<Optional<Tutor>> acceptTutor(@PathVariable("id") int id) {
		try {
			Optional<Tutor> approvedTutor = adminService.acceptTutor(id);
			if (approvedTutor.isPresent()) {
				logger.info("Approved Tutor by Admin");
				return ResponseEntity.ok().body(approvedTutor);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/rejecttutor/{id}")
	public ResponseEntity<Optional<Tutor>> rejectTutor(@PathVariable("id") int id) {
		try {
			Optional<Tutor> rejectTutor = adminService.rejectTutor(id);
			if (rejectTutor.isPresent()) {
				logger.info("Reject Tutor by Admin");
				return ResponseEntity.ok().body(rejectTutor);
			}

		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/tutorsForApproval")
	public ResponseEntity<List<Tutor>> tutorListForApproval() {
		List<Tutor> tutors = adminService.getAllTutorForApproval();
		if (tutors != null) {
			tutors.stream().forEach(s -> s.setPassword(null));
			return ResponseEntity.ok().body(tutors);
		} else
			return ResponseEntity.status(404).body(null);

	}

	@GetMapping("/blockedtutors")
	public ResponseEntity<List<Tutor>> blockedTutor() {
		try {
			List<Tutor> blockedTutorList = adminService.getAllBlockedTutor();
			if (blockedTutorList != null) {
				logger.info("Blocked TutorList for Admin");
				return ResponseEntity.ok().body(blockedTutorList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/rejectedtutors")
	public ResponseEntity<List<Tutor>> rejectedTutor() {
		try {
			List<Tutor> rejectedTutorList = adminService.getAllRejectedTutor();
			if (rejectedTutorList != null) {
				logger.info("Rejected TutorList for Admin");
				return ResponseEntity.ok().body(rejectedTutorList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/studentsForApproval")
	public ResponseEntity<List<Student>> studentListForApproval() {
		List<Student> students = adminService.getAllStudentsForApproval();
		if (students != null) {
			students.stream().forEach(s -> s.setPassword(null));
			return ResponseEntity.ok().body(students);
		} else
			return ResponseEntity.status(404).body(null);

	}

	@GetMapping("/blockstudent/{id}")
	public ResponseEntity<Optional<Student>> blockStudent(@PathVariable("id") int id) {
		try {
			Optional<Student> blockedStudent = adminService.blockStudent(id);
			if (blockedStudent.isPresent()) {
				logger.info("Block Student by Admin");
				return ResponseEntity.ok().body(blockedStudent);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/approvedstudents")
	public ResponseEntity<List<Student>> approvedStudent() {
		try {
			List<Student> approvedStudentList = adminService.approvedStudent();
			if (approvedStudentList != null) {
				logger.info("Approved StudentList for Admin");
				return ResponseEntity.ok().body(approvedStudentList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/acceptstudent/{id}")
	public ResponseEntity<Optional<Student>> acceptstudent(@PathVariable("id") int id) {
		try {
			Optional<Student> approvedStudent = adminService.acceptStudent(id);
			if (approvedStudent.isPresent()) {
				logger.info("Approved Student by Admin");
				return ResponseEntity.ok().body(approvedStudent);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/rejectstudent/{id}")
	public ResponseEntity<Optional<Student>> rejectstudent(@PathVariable("id") int id) {
		try {
			Optional<Student> rejectStudent = adminService.rejectStudent(id);
			if (rejectStudent.isPresent()) {
				logger.info("Reject Student by Admin");
				return ResponseEntity.ok().body(rejectStudent);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/blockedstudents")
	public ResponseEntity<List<Student>> blockedStudent() {
		try {
			List<Student> blockedStudentList = adminService.getAllBlockedStudent();
			if (blockedStudentList != null) {
				logger.info("Blocked StudentList for Admin");
				return ResponseEntity.ok().body(blockedStudentList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/rejectedstudents")
	public ResponseEntity<List<Student>> rejectedStudent() {
		try {
			List<Student> rejectedStudentList = adminService.getAllRejectedStudent();
			if (rejectedStudentList != null) {
				logger.info("Rejected StudentList for Admin");
				return ResponseEntity.ok().body(rejectedStudentList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/report/technology")
	public ResponseEntity<List<TutorCountDTO>> getTechReport() {
		List<TutorCountDTO> techList = techService.getTechCountforTutor();
		if (techList != null)
			return ResponseEntity.ok().body(techList);
		else
			return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/report/material")
	public ResponseEntity<List<TutorCountDTO>> getMaterialReport() {
		List<TutorCountDTO> materialList = materialService.getMaterialCountforTutor();
		if (materialList != null)
			return ResponseEntity.ok().body(materialList);
		else
			return ResponseEntity.status(404).body(null);
	}
	
	@GetMapping("/report/material/download")
	public ResponseEntity<List<TutorCountDTO>> getMaterialDownloadReport() {
		List<TutorCountDTO> materialList = materialService.getMaterialDownloadCountforTutor();
		if (materialList != null)
			return ResponseEntity.ok().body(materialList);
		else
			return ResponseEntity.status(404).body(null);
	}
}