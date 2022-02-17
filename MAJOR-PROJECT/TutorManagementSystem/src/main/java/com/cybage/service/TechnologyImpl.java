package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dto.TechnologyDTO;
import com.cybage.dto.TutorCountDTO;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;
import com.cybage.repository.TechnologyRepository;

@Service
public class TechnologyImpl implements ITechnologyService {

	@Autowired(required = true)
	private TechnologyRepository techRepo;

	@Override
	public Technology addTechnology(TechnologyDTO techDto) {
		Technology technology = new Technology();
		Tutor tutor = new Tutor();
		tutor.setId(techDto.getTutorId());
		technology.setBelongsToTutor(tutor);
		technology.setTechnologyname(techDto.getTechnologyname());
		technology.setRating(0);
		return techRepo.save(technology);
	}

	@Override
	public List<Technology> getTechnologies(int tutorId) {
		Tutor tutor = new Tutor();
		tutor.setId(tutorId);
		List<Technology> tech = techRepo.findByBelongsToTutor(tutor);
		tech.stream().forEach(t -> t.setBelongsToTutor(null));
		return tech;
	}

	@Override
	public List<TutorCountDTO> getTechCountforTutor() {
		return techRepo.findTechnologyCount();
	}

}
