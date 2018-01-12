package com.abc.database;

import java.util.ArrayList;
import java.util.List;

import com.abc.model.StudentDTO;
import com.abc.model.SubjectDTO;

public class AbcDAO
{
	
	private static List<StudentDTO> students = new ArrayList<>();
	private static List<SubjectDTO> subjects = new ArrayList<>();
	
	public static List<StudentDTO> getStudents(){
		return students;
	}
	
	public static List<SubjectDTO> getSubjects(){
		return subjects;
	}
	
	

}
