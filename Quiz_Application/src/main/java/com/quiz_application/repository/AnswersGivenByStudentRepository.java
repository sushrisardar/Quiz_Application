package com.quiz_application.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.quiz_application.entity.AnswersGivenByStudent;

public interface AnswersGivenByStudentRepository extends JpaRepositoryImplementation<AnswersGivenByStudent, 
                                                                                                  Integer> 
{

}
