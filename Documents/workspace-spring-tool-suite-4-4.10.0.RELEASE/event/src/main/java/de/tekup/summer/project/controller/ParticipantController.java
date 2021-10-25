package de.tekup.summer.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.tekup.summer.project.model.participant;
import de.tekup.summer.project.repository.ParticipantRepsitory;

@RestController
@RequestMapping("api/part")
public class ParticipantController {

	@Autowired
	ParticipantRepsitory participant;
	@PostMapping("/add")
	public ResponseEntity<participant> addparticipant(@RequestBody participant part){
		
		participant partc=participant.save(part);
		
		return new ResponseEntity<participant>(partc,HttpStatus.OK);
	}
	@GetMapping("/get")
	public ResponseEntity<List<participant>> getparticipants(){
		List<participant>partc=participant.findAll();
		return new ResponseEntity<List<participant>>(partc,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<participant> deleteProduit(@PathVariable("id") int id) {
    	
		participant.deleteById(id);
        return new ResponseEntity<participant>(HttpStatus.OK);
    	
	}
}
