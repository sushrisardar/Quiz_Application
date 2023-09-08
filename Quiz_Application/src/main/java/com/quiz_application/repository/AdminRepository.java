package com.quiz_application.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.quiz_application.entity.Admin;

public interface AdminRepository extends JpaRepositoryImplementation<Admin, Integer> 
{

}
