package com.quiz_application.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.quiz_application.entity.QuestionsAndAnswersSetByTeacher;

public interface QuestionsAndAnswersSetByTeacherRepository extends JpaRepositoryImplementation
                                                              <QuestionsAndAnswersSetByTeacher, Integer> 
{
	//custom method to check the answers of the quiz by using questionsId and answersId
	String getAnswersByQuestionId(int id);
}
