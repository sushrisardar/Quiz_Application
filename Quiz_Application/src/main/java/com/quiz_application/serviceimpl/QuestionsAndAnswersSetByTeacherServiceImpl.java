package com.quiz_application.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_application.dto.QuestionsAndAnswersSetByTeacherDTO;
import com.quiz_application.entity.AnswersGivenByStudent;
import com.quiz_application.entity.QuestionsAndAnswersSetByTeacher;
import com.quiz_application.exceptions.ResourceNotFoundException;
import com.quiz_application.repository.AnswersGivenByStudentRepository;
import com.quiz_application.repository.QuestionsAndAnswersSetByTeacherRepository;
import com.quiz_application.service.QuestionsAndAnswersSetByTeacherService;
import com.quiz_application.util.QuestionsAndAnswersSetByTeacherConverter;

@Service
public class QuestionsAndAnswersSetByTeacherServiceImpl implements QuestionsAndAnswersSetByTeacherService
{
	@Autowired
	QuestionsAndAnswersSetByTeacherRepository questionsAndAnswersSetByTeacherRepository;
	
	@Autowired
	AnswersGivenByStudentRepository answersGivenByStudentRepository;
	
	@Autowired
	QuestionsAndAnswersSetByTeacherConverter questionsConverter;
	
	@Override
	public QuestionsAndAnswersSetByTeacherDTO saveQuestions(QuestionsAndAnswersSetByTeacher questions) 
	{
		questionsAndAnswersSetByTeacherRepository.save(questions); //saving the object to the database
		
		QuestionsAndAnswersSetByTeacherDTO qDTO = questionsConverter.
				                             convertEntityToQuestionsAndAnswersSetByTeacherDTO(questions);
		return qDTO;
		
	}

	@Override
	public String createOption1(QuestionsAndAnswersSetByTeacher option1) 
	{
		return "Option 1 has been saved successfully!!";
	}
	
	@Override
	public QuestionsAndAnswersSetByTeacherDTO saveOption1(QuestionsAndAnswersSetByTeacher option1) 
	{
		questionsAndAnswersSetByTeacherRepository.save(option1); //saving the object to the database
		
		
		QuestionsAndAnswersSetByTeacherDTO qDTO = questionsConverter.
                                            convertEntityToQuestionsAndAnswersSetByTeacherDTO(option1);
        return qDTO;
	}

	@Override
	public String createOption2(QuestionsAndAnswersSetByTeacher option2) 
	{
		return "Option 2 has been saved successfully!!";
	}
	
	@Override
	public QuestionsAndAnswersSetByTeacherDTO saveOption2(QuestionsAndAnswersSetByTeacher option2) 
	{
		questionsAndAnswersSetByTeacherRepository.save(option2); //saving the object to the database
		
		
		QuestionsAndAnswersSetByTeacherDTO qDTO = questionsConverter.
                                      convertEntityToQuestionsAndAnswersSetByTeacherDTO(option2);
        return qDTO;
	}

	@Override
	public String createOption3(QuestionsAndAnswersSetByTeacher option3) 
	{
		return "Option 3 has been saved successfully!!";
	}
	
	@Override
	public QuestionsAndAnswersSetByTeacherDTO saveOption3(QuestionsAndAnswersSetByTeacher option3) 
	{
		questionsAndAnswersSetByTeacherRepository.save(option3); //saving the object to the database
		
		
		QuestionsAndAnswersSetByTeacherDTO qDTO = questionsConverter.
                                      convertEntityToQuestionsAndAnswersSetByTeacherDTO(option3);
        return qDTO;
	}

	@Override
	public String createOption4(QuestionsAndAnswersSetByTeacher option4) 
	{
		return "Option 4 has been saved successfully!!";
	}
	
	@Override
	public QuestionsAndAnswersSetByTeacherDTO saveOption4(QuestionsAndAnswersSetByTeacher option4) 
	{
		questionsAndAnswersSetByTeacherRepository.save(option4); //saving the object to the database
		
		
		QuestionsAndAnswersSetByTeacherDTO qDTO = questionsConverter.
                                   convertEntityToQuestionsAndAnswersSetByTeacherDTO(option4);
        return qDTO;
	}

	@Override
	public String createAnswers(QuestionsAndAnswersSetByTeacher answers) 
	{
		return "Answers have been saved successfully!!";
	}
	
	@Override
	public QuestionsAndAnswersSetByTeacherDTO saveAnswers(QuestionsAndAnswersSetByTeacher answers) 
	{
		questionsAndAnswersSetByTeacherRepository.save(answers);  //saving the object to the database		
		
		QuestionsAndAnswersSetByTeacherDTO qDTO = questionsConverter.
                                      convertEntityToQuestionsAndAnswersSetByTeacherDTO(answers);
        return qDTO;
	}

	@Override
	public QuestionsAndAnswersSetByTeacherDTO updateQuestionAndAnswerOfQuizById(int questionsId, 
			 QuestionsAndAnswersSetByTeacher questionsAndAnswers) throws ResourceNotFoundException 
	{
		//fetch the questions set by teacher using questionsId
		QuestionsAndAnswersSetByTeacher existQuestionsAndAnswers = 
				questionsAndAnswersSetByTeacherRepository.findById(questionsId).orElseThrow(()-> new 
                                                ResourceNotFoundException("Question","Id",questionsId));
						
		//updating the existing questions and answers with new updated questions and answers
		existQuestionsAndAnswers.setQuestions(questionsAndAnswers.getQuestions());
		existQuestionsAndAnswers.setOption_1(questionsAndAnswers.getOption_1());
		existQuestionsAndAnswers.setOption_2(questionsAndAnswers.getOption_2());
		existQuestionsAndAnswers.setOption_3(questionsAndAnswers.getOption_3());
		existQuestionsAndAnswers.setOption_4(questionsAndAnswers.getOption_4());
		existQuestionsAndAnswers.setAnswers(questionsAndAnswers.getAnswers());
		
						
		//saving the changes made
		questionsAndAnswersSetByTeacherRepository.save(existQuestionsAndAnswers);
		return questionsConverter.convertEntityToQuestionsAndAnswersSetByTeacherDTO(existQuestionsAndAnswers);
	}

	@Override
	public void deleteQuestionAndAnswerOfQuizById(int questionsId, int answersId) throws ResourceNotFoundException
	{
		QuestionsAndAnswersSetByTeacher questionsAndAnswers = questionsAndAnswersSetByTeacherRepository
           .findById(questionsId).orElseThrow(()-> new ResourceNotFoundException("Question","Id",questionsId));
		
		String questions = questionsAndAnswers.getQuestions();

		String answers = questionsAndAnswers.getAnswers();
		
		if(questions!=null)
		{
			questionsAndAnswers.setQuestions(null);
			questionsAndAnswersSetByTeacherRepository.deleteById(questionsId);
		}
		if(answers!=null)
		{
			questionsAndAnswers.setAnswers(null);
			questionsAndAnswersSetByTeacherRepository.deleteById(answersId);
		}
	}

	@Override
	public void deleteAll() 
	{
		questionsAndAnswersSetByTeacherRepository.deleteAll();
	}

	@Override
	public String checkingAnswersOfTheQuiz(int questionsId, int answersId)
	{
		if(questionsAndAnswersSetByTeacherRepository.findById(questionsId).get().getAnswers() ==
				answersGivenByStudentRepository.findById(answersId).get().getAnswers())
		{
			return "Correct";
		}
		else
		{
			return "Wrong";
		}
	}
}
