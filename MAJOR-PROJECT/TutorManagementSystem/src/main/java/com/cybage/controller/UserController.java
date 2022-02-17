package com.cybage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.model.Material;
import com.cybage.model.Technology;
import com.cybage.service.IMaterialService;
import com.cybage.service.ITechnologyService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired(required = true)
	private IMaterialService materialService;
	
	@Autowired(required = true)
	private ITechnologyService techService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/material/view/{id}")
	public ResponseEntity<List<Material>> getMaterial(@PathVariable(value = "id") int technologyId) {
		try {
			List<Material> material = materialService.getAllMaterial(technologyId);
			if (material != null) {
				material.stream().forEach(m -> m.setFileData(null));
				material.stream().forEach(m -> m.getBelongsTechnology().setBelongsToTutor(null));
				return ResponseEntity.ok().body(material);
			} else
				return ResponseEntity.status(404).body(null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body(null);
		}
	}

	@GetMapping("/material/download/{id}")
	public ResponseEntity<byte[]> downloadMaterial(@PathVariable(value = "id") int technologyId) {
		Material material = materialService.downloadFile(technologyId);
		if (material != null)
			return ResponseEntity.ok().body(material.getFileData());
		else
			return ResponseEntity.status(404).body(null);
	}

	@GetMapping("/technology/view/{id}")
	public ResponseEntity<List<Technology>> getAllTechnologies(@PathVariable(value = "id") int tutorId) {
		try {
			List<Technology> technologies = techService.getTechnologies(tutorId);
			if (technologies != null) {
				logger.info("Inside get technologies for tutor");
				return ResponseEntity.ok().body(technologies);
			} else
				return ResponseEntity.status(404).body(null);
		} catch (Exception e) {
			logger.error(e.toString());
			return ResponseEntity.status(404).body(null);
		}
	}

	@GetMapping("/feedback/getAll")
	public ResponseEntity<String> getFeedback() {
		return restTemplate.getForEntity("http://localhost:1010/feedback/getFeedback", String.class);
	}
}
