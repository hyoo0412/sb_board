package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BoardApplicationTest {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Transactional // let DB section stays alive until program ends
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("Yes, it creates automatically", answerList.get(0).getContent());
	}
	
	// declare answer object
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("Yes, it creates automatically");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//	}
	
// Question Repo =================================================	

	// deleting data
//	@Test
//	void testJpa() {
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());
//	}
	
	// modifying data
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("modified subject");
//		this.questionRepository.save(q);
//	}
	
	// findBySubjectLike
//	@Test
//	void testJpa() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("%spring boot%");
//		Question q = qList.get(0);
//		assertEquals("What is spring boot?", q.getSubject());
//	}
	
	// findBySubjectAndContent
//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubjectAndContent(
//				"What is spring boot?", "I want to learn about spring boot");
//		assertEquals(1, q.getId());
//	}
	
	// findBySubject
//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubject("What is spring boot?");
//		assertEquals(1, q.getId());
//	}
	
	// findById
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("What is spring boot?", q.getSubject());
//		}
//	}
	
	// findAll : Check if data is correctly inserted
//	@Test
//	void testJpa() {
//		
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("What is spring boot?", q.getSubject());
//	}
	
}
