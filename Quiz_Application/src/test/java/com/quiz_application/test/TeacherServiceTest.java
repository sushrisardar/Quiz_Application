package com.quiz_application.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.quiz_application.entity.QuestionsAndAnswersSetByTeacher;
import com.quiz_application.entity.Student;
import com.quiz_application.entity.Teacher;
import com.quiz_application.repository.QuestionsAndAnswersSetByTeacherRepository;
import com.quiz_application.repository.StudentRepository;
import com.quiz_application.repository.TeacherRepository;
import com.quiz_application.service.QuestionsAndAnswersSetByTeacherService;
import com.quiz_application.service.StudentService;
import com.quiz_application.service.TeacherService;

@SpringBootTest
public class TeacherServiceTest 
{
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	QuestionsAndAnswersSetByTeacherService questionsAndAnswersSetByTeacherService;
	
	@MockBean
	TeacherRepository teacherRepository;
	
	@MockBean
	StudentRepository studentRepository;
	
	@MockBean
	QuestionsAndAnswersSetByTeacherRepository questionsAndAnswersSetByTeacherRepository;
	
	@Test
	@DisplayName("Positive Test Case Checking the Teacher By Id")
	void testGetTeacherById()
	{
		Teacher teacher = Teacher.builder().teacherName("Deesha").teacherEmail("deesha@gmail.com").build();
		
		Mockito.when(teacherRepository.save(teacher)).thenReturn(teacher);
		
		assertEquals("Deesha", teacherService.saveTeacher(teacher).getTeacherName());
	}
	
	@Test
	@DisplayName("Positive Test Case Checking the Student By Id")
	void testGetStudentById()
	{
		Student student = Student.builder().studentName("Soumyadip Ger").studentEmail("soumyadip@gmail.com")
				                                                                               .build();
		
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		
		assertEquals("Soumyadip", studentService.saveStudent(student).getStudentName());
	}
	
	@Test
	@DisplayName("Negative Test Case Checking the Question By Id")
	void testGetQuestionById()
	{
		QuestionsAndAnswersSetByTeacher questions = QuestionsAndAnswersSetByTeacher.builder()
				.questions("What is the average of first 50 natural numbers?").option_1("25.30")
				.option_2("25.5").option_3("25.00").option_4("12.25").answers("25.5").build();
		
		Optional<QuestionsAndAnswersSetByTeacher> opQuestion = Optional.of(questions);
		Mockito.when(questionsAndAnswersSetByTeacherRepository.findById(questions.getQuestionId()))
		                                                                     .thenReturn(questions);
		
		String questionsId = questionsAndAnswersSetByTeacherService.getQuestionById
				                                             (questions.getQuestionId()).getQuestionsId();
		
		assertTrue(questionsId.equals("12"));
	}
}
