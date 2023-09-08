package com.quiz_application.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz_application.dto.QuestionsAndAnswersSetByTeacherDTO;
import com.quiz_application.entity.QuestionsAndAnswersSetByTeacher;

//@component converts to bean in class level
//@bean converts to bean in method level

@Component
public class QuestionsAndAnswersSetByTeacherConverter 
{
	//method to convert dto to QuestionsAndAnswersSetByTeacher entity
	public QuestionsAndAnswersSetByTeacher convertDTOToQuestionsAndAnswersSetByTeacherEntity
	                                               (QuestionsAndAnswersSetByTeacherDTO qDTO)
	{
		QuestionsAndAnswersSetByTeacher questions = new QuestionsAndAnswersSetByTeacher();
		if(qDTO!=null)
		{
			BeanUtils.copyProperties(qDTO, questions);
		}
		return questions;
	}
	
	//method to convert QuestionsAndAnswersSetByTeacher entity to dto
	public QuestionsAndAnswersSetByTeacherDTO convertEntityToQuestionsAndAnswersSetByTeacherDTO
	                                                (QuestionsAndAnswersSetByTeacher questions)
	{
		QuestionsAndAnswersSetByTeacherDTO qDTO = new QuestionsAndAnswersSetByTeacherDTO();
		if(questions!=null)
		{
			BeanUtils.copyProperties(questions, qDTO);
		}
		return qDTO;	
	}
}

