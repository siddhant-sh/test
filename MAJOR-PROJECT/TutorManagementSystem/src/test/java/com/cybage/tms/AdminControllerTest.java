package com.cybage.tms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.model.ApprovalStatus;
import com.cybage.model.Gender;
import com.cybage.model.Role;
import com.cybage.model.Student;
import com.cybage.model.Tutor;
import com.cybage.repository.StudentRepository;
import com.cybage.repository.TutorRepository;
import com.cybage.service.IAdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminControllerTest extends TutorManagementSystemApplicationTests {

	@Autowired
	private IAdminService adminService;

	@MockBean
	private TutorRepository tutorRepo;

	@MockBean
	private StudentRepository studentRepo;

	@Test
	void testTutorList() {
		when(tutorRepo
				.findAll().stream().filter(tutor -> tutor.getStatus() == ApprovalStatus.APPROVED).collect(
						Collectors.toList()))
								.thenReturn(Stream
										.of(new Tutor(1, "Jeet", "vishwajeetl@cybage.com", Gender.MALE, Role.TUTOR,
												ApprovalStatus.APPROVED, null, "Java", 4))
										.collect(Collectors.toList()));
		assertEquals(1, adminService.approvedTutors().size());
	}

	@Test
	void testTutorListForApproval() {
		when(tutorRepo.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.PENDING)
				.collect(Collectors.toList()))
						.thenReturn(Stream.of(new Tutor(1, "Jeet", "vishwajeetl@cybage.com", Gender.MALE, Role.TUTOR,
								ApprovalStatus.PENDING, null, "Java", 4)).collect(Collectors.toList()));
		assertEquals(1, adminService.getAllTutorForApproval().size());
	}

	@Test
	void testBlockedTutor() {
		when(tutorRepo.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.BLOCKED)
				.collect(Collectors.toList()))
						.thenReturn(Stream.of(new Tutor(1, "Jeet", "vishwajeetl@cybage.com", Gender.MALE, Role.TUTOR,
								ApprovalStatus.BLOCKED, null, "Java", 4)).collect(Collectors.toList()));
		assertEquals(1, adminService.getAllBlockedTutor().size());
	}

	@Test
	void testRejectedTutor() {
		when(tutorRepo
				.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.REJECTED).collect(
						Collectors.toList()))
								.thenReturn(Stream
										.of(new Tutor(1, "Jeet", "vishwajeetl@cybage.com", Gender.MALE, Role.TUTOR,
												ApprovalStatus.REJECTED, null, "Java", 4))
										.collect(Collectors.toList()));
		assertEquals(1, adminService.getAllRejectedTutor().size());
	}

	@Test
	void testStudentListForApproval() {
		when(studentRepo.findAll().stream().filter(student -> student.getStatus() == ApprovalStatus.PENDING)
				.collect(Collectors.toList()))
						.thenReturn(Stream.of(new Student(1, "Jeet", "vishwajeetl@cybage.com", Gender.MALE,
								Role.STUDENT, ApprovalStatus.PENDING, null, "BE")).collect(Collectors.toList()));
		assertEquals(1, adminService.getAllStudentsForApproval().size());
	}

	@Test
	void testApprovedStudent() {
		when(studentRepo.findAll().stream().filter(tutor -> tutor.getStatus() == ApprovalStatus.APPROVED)
				.collect(Collectors.toList()))
						.thenReturn(Stream.of(new Student(1, "Jeet", "vishwajeetl@cybage.com", Gender.MALE,
								Role.STUDENT, ApprovalStatus.APPROVED, null, "BE")).collect(Collectors.toList()));
		assertEquals(1, adminService.approvedStudent().size());
	}

	@Test
	void testBlockedStudent() {
		when(studentRepo.findAll().stream().filter(tutor -> tutor.getStatus() == ApprovalStatus.BLOCKED)
				.collect(Collectors.toList()))
						.thenReturn(Stream.of(new Student(1, "Jeet", "vishwajeetl@cybage.com", Gender.MALE,
								Role.STUDENT, ApprovalStatus.BLOCKED, null, "BE")).collect(Collectors.toList()));
		assertEquals(1, adminService.getAllBlockedStudent().size());
	}

	@Test
	void testRejectedStudent() {
		when(studentRepo.findAll().stream().filter(tutor -> tutor.getStatus() == ApprovalStatus.REJECTED)
				.collect(Collectors.toList()))
						.thenReturn(Stream.of(new Student(1, "Jeet", "vishwajeetl@cybage.com", Gender.MALE,
								Role.STUDENT, ApprovalStatus.REJECTED, null, "BE")).collect(Collectors.toList()));
		assertEquals(1, adminService.getAllRejectedStudent().size());
	}

}
