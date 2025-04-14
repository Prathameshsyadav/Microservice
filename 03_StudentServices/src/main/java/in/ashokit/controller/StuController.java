package in.ashokit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.client.SubClient;
import in.ashokit.entity.Student;
import in.ashokit.service.StuService;

@RestController
public class StuController {
	
	@Autowired
	private StuService stuService;
	
	
	@PostMapping("/student")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		boolean student2 = stuService.addStudent(student);
		if(student2) {
			return new ResponseEntity<String>("Student saved", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Student not saved", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> allStudents = stuService.getAllStudents();
		
		return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		Student student = stuService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

}
