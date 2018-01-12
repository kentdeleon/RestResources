package com.abc.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO
{

	private long studentNumber;
	private int age;
	private String firstName;
	private String lastName;
	private String gender;
	private String course;
	private int yearLevel;
	
	private List<SubjectDTO> subjects = new ArrayList<>();
	
	public StudentDTO(){
		
	}

	public StudentDTO(long studentNumber, int age, String firstName,
			String lastName, String gender, String course, int yearLevel)
	{
		this.studentNumber = studentNumber;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.course = course;
		this.yearLevel = yearLevel;
	}
	
	public StudentDTO(long studentNumber, int age, String firstName, String lastName,
			String gender, String course, int yearLevel, List<SubjectDTO> subjects){
		
		this.studentNumber = studentNumber;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.course = course;
		this.yearLevel = yearLevel;
		this.subjects.addAll(subjects);
	}
	
	public static StudentDTO generateStudentRecord(long studentNumber, int age, String firstName,
			String lastName, String gender, String course, int yearLevel){
		return new StudentDTO(studentNumber, age, firstName, lastName, gender, course, yearLevel);
	}

	public static StudentDTO generateStudentRecord(long studentNumber, int age, String firstName,
			String lastName, String gender, String course, int yearLevel, List<SubjectDTO> subjects){
		return new StudentDTO(studentNumber, age, firstName, lastName, gender, course, yearLevel, subjects);
	}
	
	public void enrolStudent(SubjectDTO subject){
		this.subjects.add(subject);
	}
	public long getStudentNumber()
	{
		return studentNumber;
	}

	public void setStudentNumber(long studentNumber)
	{
		this.studentNumber = studentNumber;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getCourse()
	{
		return course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}

	public int getYearLevel()
	{
		return yearLevel;
	}

	public void setYearLevel(int yearLevel)
	{
		this.yearLevel = yearLevel;
	}

	public List<SubjectDTO> getSubjects()
	{
		return subjects;
	}

	public void setSubjects(List<SubjectDTO> subjects)
	{
		this.subjects = subjects;
	}
	
	
	
	
}
