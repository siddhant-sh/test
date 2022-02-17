package com.cybage.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.dto.EnrolledTechDetailsDTO;
import com.cybage.dto.RatingDTO;
import com.cybage.dto.StudentDTO;
import com.cybage.dto.FeedbackDTO;
import com.cybage.model.ApprovalStatus;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Material;
import com.cybage.model.Role;
import com.cybage.model.Student;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;
import com.cybage.service.IEnrolledTechDetailsService;
import com.cybage.service.IMaterialService;
import com.cybage.service.IStudentService;
import com.cybage.service.ITutorService;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
	static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired(required = true)
	private IStudentService studentService;

	@Autowired(required = true)
	private ITutorService tutorService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired(required = true)
	private IEnrolledTechDetailsService enrolledDetailsService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired(required = true)
	private IMaterialService materialService;

	@PostMapping("/register")
	public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO student) {
		try {
			Student newStudent = studentService.registerStudent(student);
			if (newStudent != null) {

				logger.info("Inside register student");
				return ResponseEntity.ok().body(newStudent);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> studentList() {
		try {
			List<Student> studentList = studentService.getAllStudents();
			if (studentList != null) {

				logger.info("Inside student list");
				return ResponseEntity.ok().body(studentList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable(value = "id") Integer studentId) {
		try {
			Optional<Student> student = studentService.findStudentById(studentId);
			if (student.isPresent()) {

				logger.info("Get student by id");
				return ResponseEntity.ok().body(student);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/tutorList/{id}")
	public ResponseEntity<List<Technology>> tutorList(@PathVariable(value = "id") Integer studentId) {
		try {
			List<Technology> tutorList = tutorService.getAllTutorsList(studentId);
			if (tutorList != null) {

				logger.info("Inside tutor list");
				return ResponseEntity.ok().body(tutorList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@PostMapping("/enrollRequestToTutor")
	public ResponseEntity<EnrolledTechDetails> enrollToTutor(@RequestBody EnrolledTechDetailsDTO enrollTechDetails) {
		try {
			EnrolledTechDetails enroll = studentService.enrollToTutor(enrollTechDetails);
			if (enroll != null) {

				logger.info("student send enroll request");
				return ResponseEntity.ok().body(enroll);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Integer studentId,
			@RequestBody StudentDTO studentDetails) throws Exception {

		try {
			Student student = studentService.findStudentById(studentId)
					.orElseThrow(() -> new Exception("student not found for this id :: " + studentId));
			student.setUsername(studentDetails.getName());
			student.setEmail(studentDetails.getEmail());
			student.setQualification(studentDetails.getQualification());
			Student updatedStudent = studentService.saveStudent(student);
			if (updatedStudent != null) {

				logger.info("Student profile update");
				return ResponseEntity.ok().body(updatedStudent);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@PutMapping("/changePassword/{id}")
	public ResponseEntity<Student> changePassword(@PathVariable(value = "id") Integer studentId,
			@RequestBody StudentDTO studentDetails) throws Exception {
		Student student = studentService.findStudentById(studentId)
				.orElseThrow(() -> new Exception("student not found for this id :: " + studentId));
		student.setPassword(bcryptEncoder.encode(studentDetails.getPassword()));
		Student updatedStudent = studentService.saveStudent(student);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}

	@GetMapping("/pendingEnrolledList")
	public ResponseEntity<List<EnrolledTechDetails>> pendingEnrolledList() {
		List<EnrolledTechDetails> enrolledList = enrolledDetailsService
				.getAllEnrolledListByApprovalStatus(ApprovalStatus.PENDING);

		List<EnrolledTechDetails> newenrolledList = new ArrayList<>();

		enrolledList.stream().filter(els -> newenrolledList.add(new EnrolledTechDetails(els.getEnrollid(),
				els.getStatus(),

				new Student(els.getBelongsToStudents().getId(), els.getBelongsToStudents().getUsername(),
						els.getBelongsToStudents().getEmail(), els.getBelongsToStudents().getGender(), Role.STUDENT,
						els.getBelongsToStudents().getStatus(), els.getBelongsToStudents().getCreatedon(),
						els.getBelongsToStudents().getQualification()),

				new Tutor(els.getBelongsToTutor().getId(), els.getBelongsToTutor().getUsername(),
						els.getBelongsToTutor().getEmail(), els.getBelongsToTutor().getGender(), Role.TUTOR,
						els.getBelongsToTutor().getStatus(), els.getBelongsToTutor().getCreatedon(),
						els.getBelongsToTutor().getSpecialization(), els.getBelongsToTutor().getExperience()),

				new Technology(els.getBelongsToTechnology().getTechnologyid(),
						els.getBelongsToTechnology().getTechnologyname(), els.getBelongsToTechnology().getRating()),
				els.getCreatedon()))).collect(Collectors.toList());

		return new ResponseEntity<>(newenrolledList, HttpStatus.OK);

	}

	@GetMapping("/rejectedEnrolledList")
	public ResponseEntity<List<EnrolledTechDetails>> rejectedEnrolledList() {
		List<EnrolledTechDetails> enrolledList = enrolledDetailsService
				.getAllEnrolledListByApprovalStatus(ApprovalStatus.REJECTED);
		List<EnrolledTechDetails> newenrolledList = new ArrayList<>();

		enrolledList.stream().filter(els -> newenrolledList.add(new EnrolledTechDetails(els.getEnrollid(),
				els.getStatus(),

				new Student(els.getBelongsToStudents().getId(), els.getBelongsToStudents().getUsername(),
						els.getBelongsToStudents().getEmail(), els.getBelongsToStudents().getGender(), Role.STUDENT,
						els.getBelongsToStudents().getStatus(), els.getBelongsToStudents().getCreatedon(),
						els.getBelongsToStudents().getQualification()),

				new Tutor(els.getBelongsToTutor().getId(), els.getBelongsToTutor().getUsername(),
						els.getBelongsToTutor().getEmail(), els.getBelongsToTutor().getGender(), Role.TUTOR,
						els.getBelongsToTutor().getStatus(), els.getBelongsToTutor().getCreatedon(),
						els.getBelongsToTutor().getSpecialization(), els.getBelongsToTutor().getExperience()),

				new Technology(els.getBelongsToTechnology().getTechnologyid(),
						els.getBelongsToTechnology().getTechnologyname(), els.getBelongsToTechnology().getRating()),
				els.getCreatedon()))).collect(Collectors.toList());

		return new ResponseEntity<>(newenrolledList, HttpStatus.OK);

	}

	@GetMapping("/subscribedEnrolledList")
	public ResponseEntity<List<EnrolledTechDetails>> subscribedEnrolledList() {
		List<EnrolledTechDetails> enrolledList = enrolledDetailsService
				.getAllEnrolledListByApprovalStatus(ApprovalStatus.APPROVED);
		List<EnrolledTechDetails> newenrolledList = new ArrayList<>();

		enrolledList.stream().filter(els -> newenrolledList.add(new EnrolledTechDetails(els.getEnrollid(),
				els.getStatus(),

				new Student(els.getBelongsToStudents().getId(), els.getBelongsToStudents().getUsername(),
						els.getBelongsToStudents().getEmail(), els.getBelongsToStudents().getGender(), Role.STUDENT,
						els.getBelongsToStudents().getStatus(), els.getBelongsToStudents().getCreatedon(),
						els.getBelongsToStudents().getQualification()),

				new Tutor(els.getBelongsToTutor().getId(), els.getBelongsToTutor().getUsername(),
						els.getBelongsToTutor().getEmail(), els.getBelongsToTutor().getGender(), Role.TUTOR,
						els.getBelongsToTutor().getStatus(), els.getBelongsToTutor().getCreatedon(),
						els.getBelongsToTutor().getSpecialization(), els.getBelongsToTutor().getExperience()),

				new Technology(els.getBelongsToTechnology().getTechnologyid(),
						els.getBelongsToTechnology().getTechnologyname(), els.getBelongsToTechnology().getRating()),
				els.getCreatedon()))).collect(Collectors.toList());

		return new ResponseEntity<>(newenrolledList, HttpStatus.OK);
	}

	@PostMapping("/technology/rating")
	public ResponseEntity<Optional<Object>> giveRating(@RequestBody RatingDTO rating) {
		Optional<Object> enroll = enrolledDetailsService.setTechnologyRating(rating);
		if (enroll.isPresent())
			return ResponseEntity.ok().body(enroll);
		else
			return ResponseEntity.status(404).body(null);
	}

	@PostMapping("/feedback/add")
	public ResponseEntity<FeedbackDTO> addFeedback(@RequestBody FeedbackDTO feedback) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<FeedbackDTO> entity = new HttpEntity<>(feedback, headers);
		FeedbackDTO feedbackObj = restTemplate
				.exchange("http://localhost:1010/feedback/saveFeedback", HttpMethod.POST, entity, FeedbackDTO.class)
				.getBody();
		if (feedbackObj != null)
			return ResponseEntity.ok().body(feedbackObj);
		else
			return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/feedback/getAll/{id}")
	public ResponseEntity<String> getFeedback(@PathVariable int id) {
		return restTemplate.getForEntity("http://localhost:1010/feedback/getFeedback/student/" + id, String.class);
	}

	@GetMapping("/material/download/{id}")
	public ResponseEntity<byte[]> downloadMaterial(@PathVariable(value = "id") int materialId) {
		Material material = materialService.downloadFileforStudent(materialId);
		if (material != null)
			return ResponseEntity.ok().body(material.getFileData());
		else
			return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/material/view/{studId}/{id}")
	public ResponseEntity<List<Material>> getMaterial(@PathVariable(value = "studId") int studentId,
			@PathVariable(value = "id") int technologyId) {
		List<Material> material = materialService.getMaterialForStudent(studentId, technologyId);
		if (material != null) {
			material.stream().forEach(m -> m.setFileData(null));
			material.stream().forEach(m -> m.getBelongsTechnology().setBelongsToTutor(null));
			return ResponseEntity.ok().body(material);
		} else
			return ResponseEntity.status(404).body(null);
	}
}