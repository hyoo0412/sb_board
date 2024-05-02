package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	// Repository doesn't provide findBySubject
	//   You can use findBySubject without overwriting method
	// because JPA repo has ability to create and run query by
	// comprehending the method name.
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
}
