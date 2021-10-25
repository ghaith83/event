package de.tekup.summer.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.summer.project.repository.RoleRepository;

@Service
public class roleservice {
@Autowired
RoleRepository repository;

public void delete(int id) {
	 repository.deleteById(id);
}
}
