package com.quiz_application.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswersGivenByStudentDTO 
{
	private int answersId;
	
	@Size(max=100, message="Max. limit 100 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Answers given by student are required")
	private String answers;
}


