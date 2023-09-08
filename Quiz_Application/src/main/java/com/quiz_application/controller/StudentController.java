package com.quiz_application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz_application.dto.StudentDTO;
import com.quiz_application.entity.Student;
import com.quiz_application.service.StudentService;
import com.quiz_application.util.StudentConverter;

@RestController
public class StudentController 
{
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentConverter studentConverter;
	
	@PostMapping("/createStudent")
	public String createStudent(@Valid @RequestBody StudentDTO sDTO)
	{
		final Student student = studentConverter.convertDTOToStudentEntity(sDTO);
		return studentService.createStudent(student);
	}
	
	@PostMapping("/saveStudent")
	public StudentDTO saveStudent(@Valid @RequestBody StudentDTO sDTO)
	{
		final Student student = studentConverter.convertDTOToStudentEntity(sDTO);
		return studentService.saveStudent(student);
	}
}

