package com.quiz_application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class QuestionsAndAnswersSetByTeacher 
{
	@Id  //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	
	@Column(length=200, nullable=false, unique=true)
	private String questions;
	
	@Column(length=50, nullable=false, unique=true)
	private String option_1;
	
	@Column(length=50, nullable=false, unique=true)
	private String option_2;
	
	@Column(length=50, nullable=false, unique=true)
	private String option_3;
	
	@Column(length=50, nullable=false, unique=true)
	private String option_4;
	
	@Column(length=50, nullable=false)
	private String answers;
}
