package com.quiz_application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.quiz_application.dto.TeacherDTO;
import com.quiz_application.entity.Teacher;
import com.quiz_application.repository.TeacherRepository;
import com.quiz_application.service.TeacherService;
import com.quiz_application.util.TeacherConverter;

@Service
public class TeacherServiceImpl implements TeacherService 
{
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	TeacherConverter teacherConverter;
	
	@Override
	public String createTeacher(Teacher teacher) 
	{
		String teacherUsername = teacher.getTeacherEmail().substring(0,teacher.getTeacherEmail()
				                                                                  .indexOf("@"));
		teacher.setTeacherUsername(teacherUsername);
		
		String teacherPassword = teacher.getTeacherName().substring(0,3).toLowerCase();
		teacher.setTeacherPassword(teacherPassword+"123");
		
		teacherRepository.save(teacher); //saving the object to the database
		
		return "Login credentials of the teacher have been saved successfully!!";
	}

	@Override
	public TeacherDTO saveTeacher(Teacher teacher) 
	{
		String teacherUsername = teacher.getTeacherEmail().substring(0,teacher.getTeacherEmail()
                                                                                 .indexOf("@"));
		teacher.setTeacherUsername(teacherUsername);

		String teacherPassword = teacher.getTeacherName().substring(0,3).toLowerCase();
		teacher.setTeacherPassword(teacherPassword+"123");
		teacherRepository.save(teacher); //saving the object to the database
		
		
		TeacherDTO tDTO = teacherConverter.convertEntityToTeacherDTO(teacher);
		return tDTO;
	}
}
