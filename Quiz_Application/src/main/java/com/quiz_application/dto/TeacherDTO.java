package com.quiz_application.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.quiz_application.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO 
{
	private int teacherId;
	
	@Size(max=50, message="Max. limit 50 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Teacher's name is required")
	private String teacherName;
	
	@Size(max=50, message="Max. limit 50 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Teacher's email is required")
	private String teacherEmail;
	

	private String teacherUsername;
	
	private String teacherPassword;
	
	@OneToMany   //one teacher allows many students to give the quiz
	private List<Student> students;
}
