package com.quiz_application.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz_application.dto.TeacherDTO;
import com.quiz_application.entity.Teacher;

//@component converts to bean in class level
//@bean converts to bean in method level

@Component
public class TeacherConverter 
{
	//method to convert dto to teacher entity
	public Teacher convertDTOToTeacherEntity(TeacherDTO tDTO)
	{
		Teacher teacher = new Teacher();
		if(tDTO!=null)
		{
			BeanUtils.copyProperties(tDTO, teacher);
		}
		return teacher;
	}
	
	//method to convert teacher entity to dto
	public TeacherDTO convertEntityToTeacherDTO(Teacher teacher)
	{
		TeacherDTO tDTO = new TeacherDTO();
		if(teacher!=null)
		{
			BeanUtils.copyProperties(teacher, tDTO);
		}
		return tDTO;	
	}
}
