package com.abc.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.abc.model.SubjectDTO;
import com.abc.service.SubjectService;

@Path("catalogs")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class SubjectResource
{

	SubjectService subjectService = new SubjectService();
	
	@GET
	public Response getAllSubjects(@QueryParam("status") String status){
		List<SubjectDTO> subjects = subjectService.getAllSubjects();
		if(status != null){
			subjects = subjectService.getAllSubjects(status);
		}
		return Response.ok(subjects).build();
	}
	
	@GET
	@Path("/{subjectCode}")
	public Response getSubject(@PathParam("subjectCode") String subjectCode){
		SubjectDTO subject = subjectService.getSubject(subjectCode);
		
		if(subject != null){
			return Response.ok(subject).build();
		}
		
		return Response.status(Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("subject not found!").build();
	}
	
	@POST
	public Response addSubject(SubjectDTO newSubject){
		SubjectDTO addedSubject = subjectService.addSubject(newSubject);
		if(addedSubject != null){
			return Response.status(Status.CREATED).entity(addedSubject).build();
		}
		
		return Response.status(Status.NOT_ACCEPTABLE).type(MediaType.TEXT_PLAIN).entity("subject already exists!").build();
	}
	
	@PUT
	@Path("/{subjectCode}")
	public Response updateSubject(@PathParam("subjectCode") String subjectCode,SubjectDTO updateSubject){
		if(!subjectCode.toLowerCase().equalsIgnoreCase(updateSubject.getSubjectCode().toLowerCase())){
			return Response.status(Status.NOT_ACCEPTABLE).type(MediaType.TEXT_PLAIN).entity("subject code does not match with subject code in parameters").build();
		}
		 SubjectDTO oldSubject = subjectService.getSubject(subjectCode);
		 SubjectDTO updatedSubject = subjectService.updateSubject(updateSubject, subjectCode);
		 if(updatedSubject != null && !oldSubject.equals(updatedSubject)){
			 return Response.status(Status.ACCEPTED).entity(updatedSubject).build();
		 }else if(updatedSubject != null & oldSubject.equals(updatedSubject)){
			 return Response.status(Status.NOT_MODIFIED).entity(oldSubject).build();
		 }
		 
		 return Response.status(Status.NOT_ACCEPTABLE).type(MediaType.TEXT_PLAIN).entity("subject does not exists!").build();
	}
	
	
}
