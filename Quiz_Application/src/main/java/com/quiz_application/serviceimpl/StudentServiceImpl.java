package com.quiz_application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz_application.dto.StudentDTO;
import com.quiz_application.entity.Student;
import com.quiz_application.repository.StudentRepository;
import com.quiz_application.service.StudentService;
import com.quiz_application.util.StudentConverter;
@Service
public class StudentServiceImpl implements StudentService 
{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentConverter studentConverter;

	@Override
	public String createStudent(Student student) 
	{
		String studentUsername = student.getStudentEmail().substring(0,student.getStudentEmail()
                																  .indexOf("@"));
		student.setStudentUsername(studentUsername);

		String studentPassword = student.getStudentName().substring(0,3).toLowerCase();
		student.setStudentPassword(studentPassword+"123");

		studentRepository.save(student); //saving the object to the database

		return "Student login credentials saved successfully!!";
	}

	@Override
	public StudentDTO saveStudent(Student student) 
	{
		String studentUsername = student.getStudentEmail().substring(0,student.getStudentEmail()
				  .indexOf("@"));
		student.setStudentUsername(studentUsername);

		String studentPassword = student.getStudentName().substring(0,3).toLowerCase();
		student.setStudentPassword(studentPassword+"123");
		studentRepository.save(student); //saving the object to the database
		
		//log.info("Login Credentials of the Student "+questions.toString()+" have been saved successfully.");
		
		StudentDTO sDTO = studentConverter.convertEntityToStudentDTO(student);
		return sDTO;
	}
}
