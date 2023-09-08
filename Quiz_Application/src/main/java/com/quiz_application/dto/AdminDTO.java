package com.quiz_application.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO 
{
	private int adminId;
	
	@Size(max=50, message="Max. limit 50 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Teacher's username is required")
	private String teacherUsername;
	
	@Size(max=50, message="Max. limit 50 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Teacher's password is required")
	private String teacherPassword;
	
	@Size(max=50, message="Max. limit 50 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Student's username is required")
	private String studentUsername;
	
	@Size(max=50, message="Max. limit 50 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Student's password is required")
	private String studentPassword;
}

