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

import in.ashokit.entity.Subject;
import in.ashokit.service.SubService;

@RestController
public class StuController {

	@Autowired
	private SubService subService;
	
	@PostMapping("/subject")
	public ResponseEntity<String> saveSubject(@RequestBody Subject subject){
		boolean b = subService.addSubject(subject);
		if(b) {
			return new ResponseEntity<String>("Suject saved",HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Suject not saved",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/subject")
	public ResponseEntity<List<Subject>> getAllSuject(){
		List<Subject> allSubject = subService.getAllSubject();
		return new ResponseEntity<List<Subject>>(allSubject, HttpStatus.OK);
	}
	
	@GetMapping("/subject/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Integer id){
		Subject subject = subService.getSubjectById(id);
		return new ResponseEntity<Subject>(subject, HttpStatus.OK);
	}
}
