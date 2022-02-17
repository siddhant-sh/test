package com.cybage.tms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.dto.StudentDTO;
import com.cybage.model.Gender;
import com.cybage.model.Student;
import com.cybage.repository.StudentRepository;
import com.cybage.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceImplTest extends TutorManagementSystemApplicationTests {

	@Autowired
	StudentServiceImpl studentService;
	@Autowired
	StudentRepository studentRepo;
	
	
	@Test
	void testRegisterStudent() {
		StudentDTO newStudent = new StudentDTO();
		newStudent.setEmail("kamleshj@cybage.com");
		newStudent.setGender(Gender.MALE);
		newStudent.setName("Kamlesh Jadhav");
		newStudent.setPassword("Kamlesh123");
		newStudent.setQualification("BE Mechanical");
		studentService.registerStudent(newStudent);
		List<Student> student = studentService.getAllStudents();
		for (Student stud : student) {
			if(stud.getUsername().equals("Shahane Jadhav"))
				assertTrue(true);
			else
				assertFalse(true);
		}
	}

	@Test
	void testGetAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		assertNotNull(studentList);
		assertEquals(10, studentList.size());
	}

	@Test
	void testEnrollToTutor() {
		fail("Not yet implemented");
	}

	@Test
	void testFindStudentById() {
		Optional<Student> student = studentService.findStudentById(9);
		assertEquals("Lalit Chaudhari",student.get().getUsername());
	}

	@Test
	void testSaveStudent() {
		fail("Not yet implemented");
	}

}
