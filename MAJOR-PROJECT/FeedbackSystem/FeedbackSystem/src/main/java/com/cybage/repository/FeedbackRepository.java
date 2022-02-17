package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

	List<Feedback> findByReceiverid(int id);

	List<Feedback> findByRespondentid(int id);
}
