package com.cybage.service;

import java.util.List;

import com.cybage.dto.FeedbackDTO;
import com.cybage.model.Feedback;

public interface IFeedbackService {

	public List<Feedback> getAllFeedback();

	public Feedback saveFeedback(FeedbackDTO feedbacks);

	public List<Feedback> getAllFeedbackforTutor(int id);

	public List<Feedback> getAllFeedbackbyTutor(int id);

}
