package com.abc.service;

import java.util.List;

import com.abc.database.AbcDAO;
import com.abc.model.StudentDTO;

public class StudentSubjectService
{

	private List<StudentDTO> students = AbcDAO.getStudents();
	
}
