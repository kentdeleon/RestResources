package com.abc.service;

import java.util.ArrayList;
import java.util.List;

import com.abc.database.AbcDAO;
import com.abc.model.StudentDTO;
import com.abc.model.SubjectDTO;

public class StudentService
{
	private List<StudentDTO> students = AbcDAO.getStudents();
	
	public StudentService(){
		if(students.size() == 0){
		students.add(StudentDTO.generateStudentRecord(2017103645, 20, "Charles", "Maher", 
				"Male", "Mechanical Engineering", 3));
		
		students.add(StudentDTO.generateStudentRecord(2017110101, 20, "Tracy", "Jackson", 
				"Female", "Chemical Engineering", 4));
		
		SubjectDTO math101 = SubjectDTO.createSubject("College Algebra", "MATH101",
				"Basic to Intermediate Alegebra", 5, "ACTIVE");
		
		SubjectDTO ss001 = SubjectDTO.createSubject("Social Sciences", "SS001",
				"Social Science of Life and Nature", 5, "ACTIVE");
		
		for(StudentDTO student: students){
			student.enrolStudent(math101);
			student.enrolStudent(ss001);
		}
		}
	}
	
	public List<StudentDTO> getAllStudents(){
		return new ArrayList<StudentDTO>(students);
	}

	private StudentDTO findStudent(long studentNumber){
		for(StudentDTO student: students){
			if(student.getStudentNumber() == studentNumber){
				return student;
			}
		}
		return null;
	}
	public StudentDTO getStudent(long studentNumber){
		return findStudent(studentNumber);
	}
	
	public StudentDTO addStudent(StudentDTO newStudent){
		StudentDTO student = findStudent(newStudent.getStudentNumber());
		if(student == null){
			students.add(newStudent);
			System.out.println("Service: addStudent -> " + newStudent.getStudentNumber());
			return newStudent;
		}
		System.out.println("Service: addStudent -> NULL " + newStudent.getStudentNumber());
		return null;
	}
}
