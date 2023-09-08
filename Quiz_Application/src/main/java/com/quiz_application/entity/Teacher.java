package com.quiz_application.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Teacher 
{
	@Id  //primary  key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;  
	
	@Column(length=30, nullable=false)
	private String teacherName;
	
	@Column(length=50, nullable=false, unique=true)
	private String teacherEmail;
	
	@Column(length=20, nullable= false)
	private String teacherUsername;   //given by admin
	
	@Column(length=15, nullable= false)
	private String teacherPassword;    //given by admin
	
	@OneToMany   //one teacher allows many students to give the quiz
	private List<Student> students;
}

