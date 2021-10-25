package de.tekup.summer.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.summer.project.model.category;
import de.tekup.summer.project.repository.CategoryRepository;

@Service
public class ServiceCategory {
	@Autowired
 private CategoryRepository categoryRepository;
	
	public List<category>getallcat(){
		return categoryRepository.findAll();
	}
	
	
	
}
