package com.abc.service;

import java.util.ArrayList;
import java.util.List;

import com.abc.database.AbcDAO;
import com.abc.model.SubjectDTO;

public class SubjectService
{
	private List<SubjectDTO> subjects = AbcDAO.getSubjects();
	
	public SubjectService(){
		if(subjects.size() == 0){
		subjects.add(SubjectDTO.createSubject("College Algebra", "MATH101",
				"Basic to Intermediate Alegebra", 5, "ACTIVE"));
		subjects.add(SubjectDTO.createSubject("Social Sciences", "SS001",
				"Social Science of Life and Nature", 5, "ACTIVE"));
		}
	}
	
	
	public List<SubjectDTO> getAllSubjects(){
		return new ArrayList<SubjectDTO>(subjects);
	}
	
	public List<SubjectDTO> getAllSubjects(String status){
		List<SubjectDTO> subjectsByStatus = new ArrayList<>(subjects);
		for(SubjectDTO subject: subjectsByStatus){
			if(subject.getStatus().equalsIgnoreCase(status)){
				subjectsByStatus.add(subject);
			}
		}
		
		return subjectsByStatus;
	}
	
	private SubjectDTO findSubject(String subjectCode){
		for(SubjectDTO subject: subjects){
			if(subject.getSubjectCode().equals(subjectCode)){
				return subject;
			}
		}
		return null;
	}
	
	private int findSubjectIndex(String subjectCode){
		for(int i = 0; i < subjects.size(); i++){
			if(subjects.get(i).getSubjectCode().equals(subjectCode)){
				return i;
			}
		}
		return -1;
	}
	public SubjectDTO getSubject(String subjectCode){
		SubjectDTO subject = findSubject(subjectCode);
		if(subject != null){
			return subject;
		}
		
		return null;
	}
	
	public SubjectDTO addSubject(SubjectDTO newSubject){
		SubjectDTO checkSubject = findSubject(newSubject.getSubjectCode());
		if(checkSubject == null){
			subjects.add(newSubject);
			return newSubject;
		}
		return null;
	}
	
	public SubjectDTO updateSubject(SubjectDTO updatedSubject, String subjectCode){
		SubjectDTO oldSubject = findSubject(subjectCode);
		
		if(oldSubject != null){
			int indexPosition = findSubjectIndex(oldSubject.getSubjectCode());
			subjects.set(indexPosition, updatedSubject);
			return updatedSubject;
		}
		
		
		return null;
	}
}
