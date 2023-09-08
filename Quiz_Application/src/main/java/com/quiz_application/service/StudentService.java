package com.quiz_application.service;

import com.quiz_application.dto.StudentDTO;
import com.quiz_application.entity.Student;

public interface StudentService 
{
	//method used to save the login credentials of the student and then store in the database
	String createStudent(Student student);
	
	StudentDTO saveStudent(Student student);
}

