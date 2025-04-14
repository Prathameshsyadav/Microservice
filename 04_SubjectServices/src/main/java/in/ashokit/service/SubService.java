package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Subject;

public interface SubService {
	
	public List<Subject> getAllSubject();
	
	public Subject getSubjectById(Integer id);
	
	public boolean addSubject(Subject subject);

}
