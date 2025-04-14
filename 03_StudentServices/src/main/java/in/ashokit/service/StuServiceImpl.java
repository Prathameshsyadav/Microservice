package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.client.SubClient;
import in.ashokit.entity.Student;
import in.ashokit.entity.Subject;
import in.ashokit.repo.StuRepo;

@Service
public class StuServiceImpl implements StuService {
	
	@Autowired
	private StuRepo stuRepo;
	
	@Autowired
	private SubClient subClient;

	@Override
	public boolean addStudent(Student s) {
		Student student = stuRepo.save(s);
		return student.getStuId()!=null;
	}

	@Override
	public Student getStudentById(Integer id) {
		
		Student student=null;
		
		  Optional<Student> byId = stuRepo.findById(id);
		  if(byId.isPresent()) {
			   student = byId.get();
			  List<Integer> subjectIds = student.getSubjectIds();
			  List<Subject> collect = subjectIds.stream().map(subClient::getSubjectById)
			  	.collect(Collectors.toList());
			  student.setStuSub(collect);
			 
			  
		  }
		  
		  return student;
	}

	@Override
	public List<Student> getAllStudents() {
		
		 List<Student> all = stuRepo.findAll();
		 
		 for (Student student : all) {
			List<Integer> subjectIds = student.getSubjectIds();
			List<Subject> collect = subjectIds.stream().map(subClient::getSubjectById).collect(Collectors.toList());
			student.setStuSub(collect);
		}
		 
		 return all;
	}

}
