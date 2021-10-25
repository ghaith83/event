package de.tekup.summer.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.summer.project.model.participant;
import de.tekup.summer.project.model.role;
import de.tekup.summer.project.repository.RoleRepository;
import de.tekup.summer.project.service.roleservice;
@RestController
@RequestMapping("api/role")
public class RoleController {

	@Autowired
	RoleRepository repository;
	
	@Autowired
	roleservice ser;
	@RequestMapping("/add")
	public ResponseEntity<role> addrole(@RequestBody role role)throws Exception {
		if(role==null)
			throw new Exception();
		role rol=repository.save(role);
		return new ResponseEntity<role>(rol,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<role>> getparticipants(){
		List<role>role=repository.findAll();
		return new ResponseEntity<List<role>>(role,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<role> deleteProduit(@PathVariable("id") int id) {
    	
		ser.delete(id);
        return new ResponseEntity<role>(HttpStatus.OK);
    	
	}
}
