package com.quiz_application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_application.dto.QuestionsAndAnswersSetByTeacherDTO;
import com.quiz_application.entity.AnswersGivenByStudent;
import com.quiz_application.entity.QuestionsAndAnswersSetByTeacher;
import com.quiz_application.service.QuestionsAndAnswersSetByTeacherService;
import com.quiz_application.util.QuestionsAndAnswersSetByTeacherConverter;

@RestController
public class QuestionsAndAnswersSetByTeacherController 
{
	@Autowired
	QuestionsAndAnswersSetByTeacherService questionsAndAnswersSetByTeacherService;
	
	@Autowired
	QuestionsAndAnswersSetByTeacherConverter questionsConverter;
	
	@PostMapping("/saveQuestions")
	public QuestionsAndAnswersSetByTeacherDTO saveQuestions
	                                        (@Valid @RequestBody QuestionsAndAnswersSetByTeacherDTO qDTO)
	{
		final QuestionsAndAnswersSetByTeacher questions = questionsConverter.
				                                 convertDTOToQuestionsAndAnswersSetByTeacherEntity(qDTO);
		return questionsAndAnswersSetByTeacherService.saveQuestions(questions);
	}
	
	@PutMapping("/updateQuestionAndAnswerById/{id}")
	public QuestionsAndAnswersSetByTeacherDTO updateQuestionAndAnswerOfQuizById
	  (@PathVariable("id") int questionsId, @Valid @RequestBody QuestionsAndAnswersSetByTeacherDTO qDTO)
	{
		final QuestionsAndAnswersSetByTeacher questions = questionsConverter.
				                                  convertDTOToQuestionsAndAnswersSetByTeacherEntity(qDTO);
		return questionsAndAnswersSetByTeacherService
				                               .updateQuestionAndAnswerOfQuizById(questionsId, questions);
	}
	
	@DeleteMapping("/deleteQuestionAndAnswerById/{id}")
	public ResponseEntity<String> deleteQuestionAndAnswerById(@PathVariable("id") int questionsId, @PathVariable("id") 
	                                                                               int answersId)
	{
		questionsAndAnswersSetByTeacherService.deleteQuestionAndAnswerOfQuizById(questionsId, answersId);
		return new ResponseEntity<String>("Question with Id "+questionsId+" deleted successfully",
				                                                                     HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll()
	{
		questionsAndAnswersSetByTeacherService.deleteAll();
		return new ResponseEntity<String>("All questions and answers deleted successfully",
				                                                            HttpStatus.OK);
	}
	
	@GetMapping("/checkingAnswersByQId/{qId}/andAId/{aId}")
	public String checkingAnswersOfTheQuiz(@PathVariable("qId") int questionsId, @PathVariable("aId") 
	                                                                     int answersId)
	{
		return questionsAndAnswersSetByTeacherService.checkingAnswersOfTheQuiz(questionsId, answersId);
	}
}
