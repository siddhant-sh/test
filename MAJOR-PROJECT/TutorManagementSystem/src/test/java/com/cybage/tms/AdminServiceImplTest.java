package com.cybage.tms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cybage.model.ApprovalStatus;
import com.cybage.model.Student;
import com.cybage.model.Tutor;
import com.cybage.service.IAdminService;

class AdminServiceImplTest extends TutorManagementSystemApplicationTests {
	@Autowired
	private IAdminService adminService;

	@Test
	void testApprovedTutors() {
		Optional<Tutor> tutor = adminService.acceptTutor(2);
		assertEquals(ApprovalStatus.APPROVED, tutor.get().getStatus());
	}
	@Test
	void testBlockTutor() {
		Optional<Tutor> tutor= adminService.blockTutor(21);
		assertEquals(ApprovalStatus.BLOCKED,tutor.get().getStatus());
	}

	@Test
	void testRejectTutor() {
		Optional<Tutor> tutor = adminService.rejectTutor(5);
		assertEquals(ApprovalStatus.REJECTED, tutor.get().getStatus());
	}

	@Test
	void testApprovedstudent() {
		Optional<Student> student = adminService.acceptStudent(9);
		assertEquals(ApprovalStatus.APPROVED, student.get().getStatus());
	}

	@Test
	void testRejectstudent() {
		Optional<Student> student = adminService.rejectStudent(16);
		assertEquals(ApprovalStatus.REJECTED, student.get().getStatus());
	}
	@Test
	void testBlockStudent() {
		Optional<Student> student= adminService.blockStudent(22);
		assertEquals(ApprovalStatus.BLOCKED,student.get().getStatus());
	}

}
