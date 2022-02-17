package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.ApprovalStatus;
import com.cybage.model.EnrolledTechDetails;
import com.cybage.model.Student;
import com.cybage.model.Technology;
import com.cybage.model.Tutor;

@Repository
public interface EnrollTechDetailsRepository extends JpaRepository<EnrolledTechDetails, Integer> {

	public List<EnrolledTechDetails> findByStatus(ApprovalStatus status);
	
	@Query("SELECT etd FROM EnrolledTechDetails etd where etd.belongsToStudents.id= ?1")
	List<EnrolledTechDetails> getTutorDetailForStudent(Integer studentId);

	List<EnrolledTechDetails> findByBelongsToStudents(Student student);

	@Query("SELECT stud FROM EnrolledTechDetails stud where stud.belongsToTutor.id= ?1")
	List<EnrolledTechDetails> getStudentEnrollRequest(Integer tutorId);

	@Query("Update EnrolledTechDetails etd set status=?1 where etd.belongsToTutor.id= ?2 and etd.belongsToStudents.id= ?3")
	List<EnrolledTechDetails> blockStudentforTutor(ApprovalStatus status,int tutorId, int studentId);

	List<EnrolledTechDetails> findByBelongsToStudentsAndBelongsToTutor(Student student,Tutor tutor);

	public EnrolledTechDetails getByBelongsToStudentsAndBelongsToTechnology(Student student, Technology technology);
}
