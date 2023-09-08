package com.quiz_application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_application.dto.TeacherDTO;
import com.quiz_application.entity.Teacher;
import com.quiz_application.service.TeacherService;
import com.quiz_application.util.TeacherConverter;

@RestController
public class TeacherController 
{
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	TeacherConverter teacherConverter;
	
	@PostMapping("/createTeacher")
	public String createTeacher(@Valid @RequestBody TeacherDTO tDTO)
	{
		final Teacher teacher = teacherConverter.convertDTOToTeacherEntity(tDTO);
		return teacherService.createTeacher(teacher);
	}
	
	@PostMapping("/saveTeacher")
	public TeacherDTO saveTeacher(@Valid @RequestBody TeacherDTO tDTO)
	{
		final Teacher teacher = teacherConverter.convertDTOToTeacherEntity(tDTO);
		return teacherService.saveTeacher(teacher);
	}
}
