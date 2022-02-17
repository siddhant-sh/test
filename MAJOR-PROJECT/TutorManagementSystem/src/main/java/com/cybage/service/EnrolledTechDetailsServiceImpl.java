package com.cybage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dto.RatingDTO;
import com.cybage.model.ApprovalStatus;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Technology;
import com.cybage.repository.EnrollTechDetailsRepository;
import com.cybage.repository.TechnologyRepository;

@Service
public class EnrolledTechDetailsServiceImpl implements IEnrolledTechDetailsService {

	@Autowired
	private EnrollTechDetailsRepository enrolledtechdetailsrepo;
	
	@Autowired
	private TechnologyRepository techRepo;

	@Override
	public List<EnrolledTechDetails> getAllEnrolledListByApprovalStatus(ApprovalStatus status) {
		return enrolledtechdetailsrepo.findByStatus(status);
	}

	@Override
	public Optional<Object> setTechnologyRating(RatingDTO rating) {
		return enrolledtechdetailsrepo.findById(rating.getEnrollId()).map(enroll -> {
			Technology tech = techRepo.getById(enroll.getBelongsToTechnology().getTechnologyid());
			tech.setRating((tech.getRating()*tech.getStudCount()+rating.getRating())/(tech.getStudCount()+1));
			techRepo.save(tech);
			enroll.setTechRating(rating.getRating());
		    return enrolledtechdetailsrepo.save(enroll);
		});
	}

	
}
