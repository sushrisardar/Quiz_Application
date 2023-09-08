package com.quiz_application.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails 
{
	private Date timestamp;
	private String message;
	private String details;
}
