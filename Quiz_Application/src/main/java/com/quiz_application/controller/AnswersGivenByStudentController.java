package com.quiz_application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_application.dto.AnswersGivenByStudentDTO;
import com.quiz_application.entity.AnswersGivenByStudent;
import com.quiz_application.service.AnswersGivenByStudentService;
import com.quiz_application.util.AnswersGivenByStudentConverter;

@RestController
public class AnswersGivenByStudentController 
{
	@Autowired
	AnswersGivenByStudentService answersGivenByStudentService;
	
	@Autowired
	AnswersGivenByStudentConverter answersConverter;
	
	@PostMapping("/saveAnswers")
	public AnswersGivenByStudentDTO saveAnswersGivenByStudent(@Valid @RequestBody AnswersGivenByStudentDTO aDTO)
	{
		final AnswersGivenByStudent answers = answersConverter.convertDTOToAnswersGivenByStudentEntity(aDTO);
		return answersGivenByStudentService.saveGiveAnswers(answers);
	}
}
