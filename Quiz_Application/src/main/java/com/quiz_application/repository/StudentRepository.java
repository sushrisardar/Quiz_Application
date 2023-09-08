package com.quiz_application.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.quiz_application.entity.Student;

public interface StudentRepository extends JpaRepositoryImplementation<Student, Integer> 
{

}
