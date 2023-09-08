package com.quiz_application.dto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.quiz_application.entity.Teacher;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDTO 
{
	private int studentId;  
	
	@Size(max=50, message="Max. limit 50 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Student's password is required")
	private String studentName;
	
	@Size(max=50, message="Max. limit 50 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Student's password is required")
	private String studentEmail;
	

	private String studentUsername;
	

	private String studentPassword;
	
	@ManyToOne   //many students are allowed to give the quiz under the supervision of one teacher
	private Teacher teacher;
}
