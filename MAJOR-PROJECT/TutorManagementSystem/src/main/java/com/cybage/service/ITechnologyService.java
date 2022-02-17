package com.cybage.service;

import java.util.List;

import com.cybage.dto.TutorCountDTO;
import com.cybage.dto.TechnologyDTO;
import com.cybage.model.Technology;

public interface ITechnologyService {

	Technology addTechnology(TechnologyDTO techDto);

	List<Technology> getTechnologies(int tutorId);

	List<TutorCountDTO> getTechCountforTutor();

}
