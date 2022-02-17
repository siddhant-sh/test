package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.dto.MaterialDTO;
import com.cybage.dto.TechnologyDTO;
import com.cybage.dto.TutorDTO;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Material;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;
import com.cybage.service.IMaterialService;
import com.cybage.service.ITechnologyService;
import com.cybage.service.ITutorService;

@CrossOrigin
@RestController
@RequestMapping("/tutor")
public class TutorController {

	static final Logger logger = LoggerFactory.getLogger(TutorController.class);
	@Autowired(required = true)
	private ITutorService tutorService;

	@Autowired(required = true)
	private ITechnologyService techService;

	@Autowired(required = true)
	private IMaterialService materialService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/register")
	public ResponseEntity<Tutor> saveTutor(@RequestBody TutorDTO tutorDto) {
		Tutor tutor = tutorService.registerTutor(tutorDto);
		if (tutor != null)
			return ResponseEntity.ok().body(tutor);
		else
			return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/tutors")
	public ResponseEntity<List<Tutor>> tutorList() {
		try {
			List<Tutor> tutorList = tutorService.getAllTutors();
			if (tutorList != null) {
				logger.info("Inside get tutorList");
				return ResponseEntity.ok().body(tutorList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/profile/{id}")
	public ResponseEntity<TutorDTO> tutorProfile(@PathVariable(value = "id") Integer tutorId) {
		try {
			TutorDTO tutor = tutorService.getTutorProfile(tutorId);
			if (tutor != null) {

				logger.info("Get tutor profile by id");
				return ResponseEntity.ok().body(tutor);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@PutMapping("/updateprofile/{id}")
	public ResponseEntity<Tutor> updateTutor(@PathVariable(value = "id") Integer tutorId,
			@RequestBody TutorDTO tutorDetails) throws Exception {
		Tutor tutor = tutorService.findTutorById(tutorId)
				.orElseThrow(() -> new Exception("student not found for this id :: " + tutorId));

		tutor.setUsername(tutorDetails.getName());
		tutor.setEmail(tutorDetails.getEmail());
		tutor.setSpecialization(tutorDetails.getSpecialization());
		tutor.setExperience(tutorDetails.getExperience());
		Tutor updatedTutor = tutorService.saveTutor(tutor);
		return ResponseEntity.ok(updatedTutor);
	}

	@GetMapping("/enrollrequest/{id}")
	public ResponseEntity<List<EnrolledTechDetails>> studentEnrollRequest(@PathVariable(value = "id") Integer tutorId) {
		try {
			List<EnrolledTechDetails> enrollList = tutorService.getStudentEnrollRequest(tutorId);
			if (enrollList != null) {
				logger.info("Inside get enroll request list for tutor");
				return ResponseEntity.ok().body(enrollList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/acceptenrollment/{id}")
	public ResponseEntity<Optional<EnrolledTechDetails>> acceptStudentEnrollment(@PathVariable(value = "id") int id) {
		try {
			Optional<EnrolledTechDetails> enroll = tutorService.acceptStudentEnrollment(id);
			if (enroll.isPresent()) {
				logger.info("Inside accept enroll request list for tutor");
				return ResponseEntity.ok().body(enroll);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);

	}

	@GetMapping("/rejectenrollemt/{id}")
	public ResponseEntity<Optional<EnrolledTechDetails>> rejectTutor(@PathVariable("id") int id) {
		try {
			Optional<EnrolledTechDetails> enroll = tutorService.rejectStudentEnrollment(id);
			if (enroll.isPresent()) {
				logger.info("Inside reject enroll request list for tutor");
				return ResponseEntity.ok().body(enroll);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/enrolledstudents/{id}")
	public ResponseEntity<List<EnrolledTechDetails>> enrolledStudents(@PathVariable(value = "id") Integer tutorId) {
		try {
			List<EnrolledTechDetails> enrolledList = tutorService.getEnrolledStudents(tutorId);
			if (enrolledList != null) {
				logger.info("Inside get enrolled student list for tutor");
				return ResponseEntity.ok().body(enrolledList);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ResponseEntity.status(404).body(null);
	}

	@PostMapping("/technology/add")
	public ResponseEntity<Technology> addTechnology(@RequestBody TechnologyDTO techDto) {
		Technology technology = techService.addTechnology(techDto);
		if (technology != null)
			return ResponseEntity.ok().body(technology);
		else
			return ResponseEntity.status(404).body(null);
	}

	@PostMapping(value = "/material/add")
	public ResponseEntity<Material> addMaterial(@ModelAttribute MaterialDTO materialDto) {
		Material material = materialService.addMaterial(materialDto);
		if (material != null)
			return ResponseEntity.ok().body(material);
		else
			return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/material/view/{tutorId}/{id}")
	public ResponseEntity<List<Material>> getMaterial(@PathVariable(value = "tutorId") int tutorId,
			@PathVariable(value = "id") int technologyId) {
		List<Material> material = materialService.getAllMaterialforTutor(tutorId, technologyId);
		if (material != null) {
			material.stream().forEach(m -> m.setFileData(null));
			material.stream().forEach(m -> m.getBelongsTechnology().setBelongsToTutor(null));
			return ResponseEntity.ok().body(material);
		} else
			return ResponseEntity.status(404).body(null);
	}

	@DeleteMapping(value = "/material/delete/{id}")
	public ResponseEntity<Integer> deleteMaterial(@PathVariable(value = "id") int materialId) {
		if (materialService.deleteMaterial(materialId))
			return ResponseEntity.ok().body(materialId);
		else
			return ResponseEntity.status(404).body(null);
	}

	@PutMapping("/changePassword/{id}")
	public ResponseEntity<Tutor> changePassword(@PathVariable(value = "id") Integer tutorId,
			@RequestBody TutorDTO tutortDetails) throws Exception {
		Tutor tutor = tutorService.findTutorById(tutorId)
				.orElseThrow(() -> new Exception("tutor not found for this id :: " + tutorId));
		tutor.setPassword(bcryptEncoder.encode(tutortDetails.getPassword()));
		Tutor updatedTutor = tutorService.saveTutor(tutor);
		return new ResponseEntity<>(updatedTutor, HttpStatus.OK);
	}

	@GetMapping("/enrolledstudents/block/{id}")
	public ResponseEntity<List<EnrolledTechDetails>> blockStudent(@PathVariable(value = "id") int id) {
		List<EnrolledTechDetails> blockList = tutorService.blockStudentEnrollment(id);
		if (blockList != null)
			return ResponseEntity.ok().body(blockList);
		else
			return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/feedback/getAll/{id}")
	public ResponseEntity<String> getFeedback(@PathVariable int id) {
		return restTemplate.getForEntity("http://localhost:1010/feedback/getFeedback/tutor/" + id, String.class);
	}

}
