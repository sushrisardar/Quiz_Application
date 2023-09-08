package com.quiz_application.service;

import com.quiz_application.dto.QuestionsAndAnswersSetByTeacherDTO;
import com.quiz_application.entity.AnswersGivenByStudent;
import com.quiz_application.entity.QuestionsAndAnswersSetByTeacher;


public interface QuestionsAndAnswersSetByTeacherService 
{
	//method to save questions created by teacher in database
	QuestionsAndAnswersSetByTeacherDTO saveQuestions(QuestionsAndAnswersSetByTeacher questions);
	
	//method to save option 1 of the question created by teacher in database
	String createOption1(QuestionsAndAnswersSetByTeacher option1);
	
	QuestionsAndAnswersSetByTeacherDTO saveOption1(QuestionsAndAnswersSetByTeacher option1);
	
	//method to save option 2 of the question created by teacher in database
	String createOption2(QuestionsAndAnswersSetByTeacher option2);
	
	QuestionsAndAnswersSetByTeacherDTO saveOption2(QuestionsAndAnswersSetByTeacher option2);
	
	//method to save option 3 of the question created by teacher in database
	String createOption3(QuestionsAndAnswersSetByTeacher option3);
	
	QuestionsAndAnswersSetByTeacherDTO saveOption3(QuestionsAndAnswersSetByTeacher option3);
		
	//method to save option 4 of the question created by teacher in database
	String createOption4(QuestionsAndAnswersSetByTeacher option4);
	
	QuestionsAndAnswersSetByTeacherDTO saveOption4(QuestionsAndAnswersSetByTeacher option4);
	
	//method to save answers to the questions created by teacher in database
	String createAnswers(QuestionsAndAnswersSetByTeacher answers);
	
	QuestionsAndAnswersSetByTeacherDTO saveAnswers(QuestionsAndAnswersSetByTeacher answers);
	
	//method to update one question of the quiz present in the database
	QuestionsAndAnswersSetByTeacherDTO updateQuestionAndAnswerOfQuizById(int questionsId,
			                                          QuestionsAndAnswersSetByTeacher questionsAndAnswers);
			
//	//method to delete one question of the quiz
	void deleteQuestionAndAnswerOfQuizById(int questionsId, int abswersId);
			
	//method to delete all the questions of the quiz from the database
	void deleteAll();
	
	//method to create custom method
	String checkingAnswersOfTheQuiz(int questionsId, int answersId);
}
