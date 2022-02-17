package com.cybage.tms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cybage.dto.TutorDTO;
import com.cybage.model.ApprovalStatus;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Tutor;
import com.cybage.service.IMaterialService;
import com.cybage.service.ITechnologyService;
import com.cybage.service.ITutorService;

class TutorServiceImplTest extends TutorManagementSystemApplicationTests{

	@Autowired(required = true)
	private ITutorService tutorService;

	
	
	@Autowired(required = true)
	private ITechnologyService techService;

	@Autowired(required = true)
	private IMaterialService materialService;

	
//	@Test
//	void testRegisterTutor() {
//		Tutor tutor =tutorService.registerTutor(new Tutor);
//		fail("Not yet implemented");
//	}


	@Test
	void testGetTutorProfile() {
		TutorDTO tutor=tutorService.getTutorProfile(2);
		assertEquals("Prajyot Waradkar", tutor.getName());
	}

	@Test
	void testFindTutorById() {
		Optional<Tutor> tutor=tutorService.findTutorById(2);
		assertEquals("Prajyot Waradkar", tutor.get().getUsername());
	}

//	@Test
//	void testSaveTutor() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetStudentEnrollRequest() {
		List<EnrolledTechDetails> enroll=tutorService.getStudentEnrollRequest(2);
		assertEquals(0, enroll.size());
	}

	
	@Test
	void testRejectStudentEnrollment() {
		Optional<EnrolledTechDetails> enrolled=tutorService.rejectStudentEnrollment(31);
		assertEquals(ApprovalStatus.REJECTED, enrolled.get().getStatus());
	}

	@Test
	void testGetEnrolledStudents() {
		List<EnrolledTechDetails> enrolled=tutorService.getEnrolledStudents(2);
		assertEquals(7, enrolled.size());
	}

	
}
