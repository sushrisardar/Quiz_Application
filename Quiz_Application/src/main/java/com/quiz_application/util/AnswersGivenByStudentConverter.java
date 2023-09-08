package com.quiz_application.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz_application.dto.AnswersGivenByStudentDTO;
import com.quiz_application.entity.AnswersGivenByStudent;

//@component converts to bean in class level
//@bean converts to bean in method level

@Component
public class AnswersGivenByStudentConverter 
{
	//method to convert dto to AnswersGivenByStudent entity
	public AnswersGivenByStudent convertDTOToAnswersGivenByStudentEntity(AnswersGivenByStudentDTO aDTO)
	{
		AnswersGivenByStudent answers = new AnswersGivenByStudent();
		if(aDTO!=null)
		{
			BeanUtils.copyProperties(aDTO, answers);
		}
		return answers;
	}
	
	//method to convert AnswersGivenByStudent entity to dto
	public AnswersGivenByStudentDTO convertEntityToAnswersGivenByStudentDTO(AnswersGivenByStudent answers)
	{
		AnswersGivenByStudentDTO aDTO = new AnswersGivenByStudentDTO();
		if(answers!=null)
		{
			BeanUtils.copyProperties(answers, aDTO);
		}
		return aDTO;	
	}
}

