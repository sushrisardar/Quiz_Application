package com.quiz_application.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.quiz_application.entity.Teacher;

public interface TeacherRepository extends JpaRepositoryImplementation<Teacher, Integer> 
{

}
