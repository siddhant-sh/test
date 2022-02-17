package com.cybage.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dto.FeedbackDTO;
import com.cybage.model.Feedback;
import com.cybage.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService{

	@Autowired
	private FeedbackRepository feedbackRepo;
	
	

	@Override
	public List<Feedback> getAllFeedback() {
		
		return feedbackRepo.findAll();
	}



	@Override
	public Feedback saveFeedback(FeedbackDTO feedbacks) {
		Feedback feedback = new Feedback(feedbacks.getRespondentid(),feedbacks.getRespondentname(),feedbacks.getReceiverid(),feedbacks.getReceivername(),feedbacks.getRating());
		feedback.setGivenon(LocalDateTime.now());
		return feedbackRepo.save(feedback);
	}



	@Override
	public List<Feedback> getAllFeedbackforTutor(int id) {
		return feedbackRepo.findByReceiverid(id);
	}



	@Override
	public List<Feedback> getAllFeedbackbyTutor(int id) {
		return feedbackRepo.findByRespondentid(id);
	}

}
