package com.quiz_application.service;

import com.quiz_application.dto.AnswersGivenByStudentDTO;
import com.quiz_application.entity.AnswersGivenByStudent;

public interface AnswersGivenByStudentService 
{
	//method to save answers given by student and then store in the database
//	String createGiveAnswers(AnswersGivenByStudent answers);
	
	AnswersGivenByStudentDTO saveGiveAnswers(AnswersGivenByStudent answers);
}
