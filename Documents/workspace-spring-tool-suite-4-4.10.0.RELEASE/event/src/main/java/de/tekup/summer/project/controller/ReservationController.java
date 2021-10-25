package de.tekup.summer.project.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tekup.summer.project.model.client;
import de.tekup.summer.project.model.reservation;
import de.tekup.summer.project.model.salle;
import de.tekup.summer.project.repository.ClientRepository;
import de.tekup.summer.project.repository.SalleRepository;
import de.tekup.summer.project.service.ServiceReservation;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {
	@Autowired
	ServiceReservation serviceres;
	@Autowired
	SalleRepository reposalle;
	@Autowired
	 ClientRepository RepoClient;
	public ReservationController(ServiceReservation serviceres) {
		super();
		this.serviceres = serviceres;
	}


	@PostMapping("/add/{id}")
	@JsonIgnore
	public ResponseEntity<reservation> addReservation(@RequestBody reservation res ,@PathVariable ("id") int id) throws Exception {
		java.util.List<salle>salles=reposalle.findAll();
	  salle	salle1=null;
	  client client=null;
	  
	List<client>clients=RepoClient.findAll();
	 int taille=clients.size();
	   for (client client2 : clients) {
		if (client2.getId()==taille)
			client=client2;
	}
		for (salle salle : salles) {
			if (salle.getIdsalle()==id)
				salle1=salle;
		     
		}
		if(salle1==null) {
			throw new Exception("salle with id "+id+" does not exist" );
		}
		
		
		
		 Date dateREquest=res.getDatereservation();
		 if(dateREquest.equals(null)) {
			 throw new Exception("date null");
		 }
			if(dateREquest!=null&& !dateREquest.equals("")) {
				reservation reserveInTest=null;
				 reserveInTest=serviceres.verifReservation(dateREquest,id);
				if(reserveInTest!=null) {
				throw new Exception("date already exist");
				}
				else {
					
					res.setSalle(salle1);
					res.setNomsalle(res.getSalle().getNom());
					
				}
			
			} 
			
		  
		  reservation c=serviceres.addreservation(res);
		return new ResponseEntity<reservation>(c,HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<reservation>>reservationId(@PathVariable("id")int id){
		Optional<reservation> res=this.serviceres.getReservationById(id);
		return new ResponseEntity<Optional<reservation>>(res,HttpStatus.OK);
	}
	
	@GetMapping("/get/size")
	public ResponseEntity<Integer>sizereservation(){
		int size=this.serviceres.sizereservation();
		return new ResponseEntity<Integer>(size,HttpStatus.OK);
	}
		
	@GetMapping("/find/all")
	public ResponseEntity<List<reservation>>reservationall(){
		List<reservation> res=this.serviceres.findall();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
}
