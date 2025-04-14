package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Subject;
import in.ashokit.repo.SubRepo;

@Service
public class SubServiceImpl implements SubService {
	
	@Autowired
	private SubRepo subRepo;

	@Override
	public List<Subject> getAllSubject() {
		return subRepo.findAll();
	}

	@Override
	public Subject getSubjectById(Integer id) {
		return subRepo.findById(id).get();
	}

	@Override
	public boolean addSubject(Subject subject) {
		Subject save = subRepo.save(subject);
		return save.getSubId()!=null;
	}

}
