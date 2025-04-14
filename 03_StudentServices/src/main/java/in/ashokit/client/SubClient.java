package in.ashokit.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ashokit.entity.Subject;

@FeignClient(name = "SUBJECT-SERVICES")
public interface SubClient {
	
	@GetMapping("/subject/{id}")
	public Subject getSubjectById(@PathVariable Integer id);
	
//	@GetMapping("/subject")
//	public List<Subject> getAllSubject();

}
