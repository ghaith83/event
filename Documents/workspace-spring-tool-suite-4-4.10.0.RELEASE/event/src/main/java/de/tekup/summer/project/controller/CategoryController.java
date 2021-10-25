package de.tekup.summer.project.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import de.tekup.summer.project.model.category;
import de.tekup.summer.project.repository.CategoryRepository;
import de.tekup.summer.project.service.ServiceCategory;


@RestController
@RequestMapping("/api/category")
@JsonIgnoreType
public class CategoryController {

	
	 
	 private ServiceCategory servce;
	
	 public CategoryController(ServiceCategory servce) {
		super();
		this.servce = servce;
	}

	@GetMapping("/all")
	public ResponseEntity<List<category>>getallcat(){
		List<category>cats=servce.getallcat();
		return new ResponseEntity<>(cats,HttpStatus.OK);
	}
}
