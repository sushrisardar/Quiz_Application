package com.quiz_application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_application.dto.AnswersGivenByStudentDTO;
import com.quiz_application.entity.AnswersGivenByStudent;
import com.quiz_application.repository.AnswersGivenByStudentRepository;
import com.quiz_application.service.AnswersGivenByStudentService;
import com.quiz_application.util.AnswersGivenByStudentConverter;
@Service
public class AnswersGivenByStudentImpl implements AnswersGivenByStudentService
{
	@Autowired
	AnswersGivenByStudentRepository answersGivenByStudentRepository;
	
	@Autowired
	AnswersGivenByStudentConverter answersConverter;
	
//	@Override
//	public String createGiveAnswers(AnswersGivenByStudent answers) 
//	{
//		return "Answers given by the student have been saved successfully!!";
//	}

	@Override
	public AnswersGivenByStudentDTO saveGiveAnswers(AnswersGivenByStudent answers) 
	{
		answersGivenByStudentRepository.save(answers); //saving the object to the database
		
		//log.info("Answers given by the Student "+questions.toString()+" have been saved successfully.");
		
		AnswersGivenByStudentDTO aDTO = answersConverter.convertEntityToAnswersGivenByStudentDTO(answers);
		return aDTO;
	}
}
