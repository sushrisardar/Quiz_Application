package com.quiz_application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student 
{
	@Id  //primary  key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;  
	
	@Column(length=30, nullable=false)
	private String studentName;
	
	@Column(length=50, nullable=false, unique=true)
	private String studentEmail;
	
	@Column(length=20, nullable= false)
	private String studentUsername;   //given by admin
	
	@Column(length=15, nullable= false)
	private String studentPassword;   //given by admin
	
	@ManyToOne   //many students are allowed to give the quiz under the supervision of one teacher
	private Teacher teacher;
}
