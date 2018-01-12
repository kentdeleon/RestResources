package com.abc.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.abc.model.StudentDTO;
import com.abc.service.StudentService;

@Path("students")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class StudentResource
{

	StudentService studentService = new StudentService();
	
	@GET
	public Response getAllStudents(){
		List<StudentDTO> students = studentService.getAllStudents();
		return Response.ok(students).build();
	}
	
	@GET
	@Path("/{studentNumber}")
	public Response getStudent(@PathParam("studentNumber") long studentNumber){
		StudentDTO student = studentService.getStudent(studentNumber);
		
		if(student != null){
			return Response.ok(student).build();
		}
		
		return Response.status(Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Student not found").build();
	}
	
	@POST
	public Response addStudent(StudentDTO student){
		StudentDTO newStudent = studentService.addStudent(student);
		
		if(newStudent != null){
			return Response.status(Status.CREATED).entity(newStudent).build();
		}
		
		return Response.status(Status.NOT_ACCEPTABLE)
					   .type(MediaType.TEXT_PLAIN)
					   .entity("Student Already exists!")
					   .build();
	}
	
	@Path("{studentNumber}/subjects")
	public StudentSubjectResource getStudentSubjectResource(){
		return new StudentSubjectResource();
	}
	
}
