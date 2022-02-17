package com.cybage.service;

import java.util.List;
import java.util.Optional;

import com.cybage.dto.RatingDTO;
import com.cybage.model.ApprovalStatus;
import com.cybage.model.EnrolledTechDetails;

public interface IEnrolledTechDetailsService {
	
	public List<EnrolledTechDetails> getAllEnrolledListByApprovalStatus(ApprovalStatus status);
	public Optional<Object> setTechnologyRating(RatingDTO rating);
}
