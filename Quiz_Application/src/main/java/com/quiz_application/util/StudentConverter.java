package com.quiz_application.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz_application.dto.StudentDTO;
import com.quiz_application.entity.Student;

//@component converts to bean in class level
//@bean converts to bean in method level

@Component
public class StudentConverter 
{
	//method to convert dto to student entity
	public Student convertDTOToStudentEntity(StudentDTO sDTO)
	{
		Student student = new Student();
		if(sDTO!=null)
		{
			BeanUtils.copyProperties(sDTO, student);
		}
		return student;
	}
	
	//method to convert student entity to dto
	public StudentDTO convertEntityToStudentDTO(Student student)
	{
		StudentDTO sDTO = new StudentDTO();
		if(student!=null)
		{
			BeanUtils.copyProperties(student, sDTO);
		}
		return sDTO;	
	}
}

