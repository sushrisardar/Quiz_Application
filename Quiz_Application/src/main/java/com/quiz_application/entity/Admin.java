package com.quiz_application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
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
public class Admin 
{
	@Id  //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@Column(length=30, nullable=false)
	private String teacherUsername;
	
	@Column(length=30, nullable=false)
	private String teacherPassword;
	
	@Column(length=30, nullable=false)
	private String studentUsername;
	
	@Column(length=30, nullable=false)
	private String studentPassword;
}
