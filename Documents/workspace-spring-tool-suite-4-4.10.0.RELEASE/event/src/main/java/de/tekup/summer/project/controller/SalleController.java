package de.tekup.summer.project.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonIgnoreType;

import de.tekup.summer.project.model.salle;
import de.tekup.summer.project.service.ServiceSalle;


@RestController
@RequestMapping("/api/salle")
public class SalleController {
	
	private final ServiceSalle ServiceSalle;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<salle>>getAllSalle(){
		List<salle>Salle=ServiceSalle.getAllSalles();
		return new ResponseEntity<>(Salle,HttpStatus.OK);
	}


	public SalleController(de.tekup.summer.project.service.ServiceSalle serviceSalle) {
		super();
		ServiceSalle = serviceSalle;
	}
	@GetMapping("/find/{id}")
    public ResponseEntity<Optional<salle>> getProduitById (@PathVariable("id") int id) {
    	Optional<salle> salle = ServiceSalle.getsalle(id);
        return new ResponseEntity<Optional<salle>>(salle, HttpStatus.OK);
    }
	@GetMapping("/nom/{id}")
    public ResponseEntity<salle> getProduitByName (@PathVariable("nom") String nom) {
    	salle salle = ServiceSalle.getsalleNom(nom);
        return new ResponseEntity<salle>(salle, HttpStatus.OK);
    }
    @GetMapping("/bycat/{catnom}")
    public ResponseEntity<List<salle>>getsallebycat(@PathVariable("catnom")String catnom){
    	List<salle>salles=ServiceSalle.getsallebycat(catnom);
    	return new ResponseEntity<List<salle>>(salles,HttpStatus.OK);
    }
}
