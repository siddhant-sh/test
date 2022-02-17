package com.cybage.tms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cybage.dto.TutorCountDTO;
import com.cybage.model.Technology;
import com.cybage.service.ITechnologyService;

class TechnologyImplTest extends TutorManagementSystemApplicationTests{

	@Autowired
	private ITechnologyService techService;

	@Test
	void testGetTechnologies() {
		List<Technology> techlist = techService.getTechnologies(3);
		assertEquals(4, techlist.size());
	}

	@Test
	void testGetTechCountforTutor() {
		List<TutorCountDTO> techCount = techService.getTechCountforTutor();
		assertEquals(4, techCount.get(2).getCount());
	}

}
