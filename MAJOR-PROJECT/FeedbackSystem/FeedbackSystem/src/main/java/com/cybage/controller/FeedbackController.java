package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dto.FeedbackDTO;
import com.cybage.model.Feedback;
import com.cybage.service.IFeedbackService;


@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired(required = true)
	private IFeedbackService feedbackService;

	
	@GetMapping("/getFeedback")
	public ResponseEntity<List<Feedback>> tutorList() {
		
		try {
			List<Feedback> feedback=feedbackService.getAllFeedback();
			if(feedback!=null)
				return ResponseEntity.ok().body(feedback);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
			return ResponseEntity.status(404).body(null);
		
	}
	
	@PostMapping("/saveFeedback")
	public ResponseEntity<Feedback> saveTutor(@RequestBody FeedbackDTO feedbacks){
		Feedback feedback = feedbackService.saveFeedback(feedbacks);
		if (feedback != null)
			return ResponseEntity.ok().body(feedback);
		else
			return ResponseEntity.status(404).body(null);
	}
	
	@GetMapping("/getFeedback/tutor/{id}")
	public ResponseEntity<List<Feedback>> tutorFeedback(@PathVariable int id) {
		List<Feedback> feedback=feedbackService.getAllFeedbackforTutor(id);
		if(feedback!=null)
			return ResponseEntity.ok().body(feedback);
		else
			return ResponseEntity.status(404).body(null);
	}
	
	@GetMapping("/getFeedback/student/{id}")
	public ResponseEntity<List<Feedback>> studentFeedback(@PathVariable int id) {
		List<Feedback> feedback=feedbackService.getAllFeedbackbyTutor(id);
		if(feedback!=null)
			return ResponseEntity.ok().body(feedback);
		else
			return ResponseEntity.status(404).body(null);
	}
}

