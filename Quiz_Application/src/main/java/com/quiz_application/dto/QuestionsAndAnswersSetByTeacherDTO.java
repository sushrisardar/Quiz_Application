package com.quiz_application.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionsAndAnswersSetByTeacherDTO 
{
	private int questionId;
	
	@Size(max=200, message="Max. limit 200 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Questions set by teacher are required")
	private String questions;
	
	@Size(max=100, message="Max. limit 100 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Option 1 set by teacher is required")
	private String option_1;
	
	@Size(max=100, message="Max. limit 100 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Option 2 set by teacher is required")
	private String option_2;
	
	@Size(max=50, message="Max. limit 100 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Option 3 set by teacher is required")
	private String option_3;
	
	@Size(max=50, message="Max. limit 100 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Option 4 set by teacher is required")
	private String option_4;
	
	@Size(max=100, message="Max. limit 100 characters")
	@Size(min=2,message="Min. 2 characters required")
	@NotNull(message="Answers set by teacher are required")
	private String answers;
}
