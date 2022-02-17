package com.cybage.tms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cybage.dto.TutorCountDTO;
import com.cybage.model.Material;
import com.cybage.service.IMaterialService;

class MaterialServiceImplTest extends TutorManagementSystemApplicationTests {
	@Autowired
	private IMaterialService matService;

	@Test
	void testGetAllMaterial() {
		List<Material> matList = matService.getAllMaterial(1);
		assertEquals(1, matList.size());
	}

	@Test
	void testGetMaterialCountforTutor() {
		List<TutorCountDTO> materialCount = matService.getMaterialCountforTutor();
		assertEquals(3, materialCount.get(2).getCount());
	}

	@Test
	void testGetAllMaterialforTutor() {
		List<Material> matList = matService.getAllMaterial(1);
		assertEquals(1, matList.size());
	}

}
