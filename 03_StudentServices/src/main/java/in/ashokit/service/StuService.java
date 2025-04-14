package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Student;

public interface StuService {
	
	public boolean addStudent(Student s);
	
	public Student getStudentById(Integer id);
	
	public List<Student> getAllStudents();

}
