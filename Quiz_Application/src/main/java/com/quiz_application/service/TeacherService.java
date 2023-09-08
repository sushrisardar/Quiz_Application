package com.quiz_application.service;

import com.quiz_application.dto.TeacherDTO;
import com.quiz_application.entity.Teacher;

public interface TeacherService 
{
	//method used to save the login credentials of the teacher and then store in the database
	String createTeacher(Teacher teacher);
	
	TeacherDTO saveTeacher(Teacher teacher);
}
