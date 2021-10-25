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

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tekup.summer.project.model.planing;
import de.tekup.summer.project.model.reservation;
import de.tekup.summer.project.model.salle;
import de.tekup.summer.project.repository.PlaningRepository;
import de.tekup.summer.project.repository.ReservationERepository;
import de.tekup.summer.project.repository.SalleRepository;
import de.tekup.summer.project.service.Serviceplaning;

@RestController
@RequestMapping("api/planing")
public class PlaninngControle {
	@Autowired
	private PlaningRepository repo;
	 @Autowired
	 private Serviceplaning serviceplaning;
	 @Autowired
		SalleRepository reposalle;
	 @Autowired
		ReservationERepository repores;
	 @PostMapping("/add/{id}/{idreservation}")
		@JsonIgnore
		public ResponseEntity<planing> addPlaning(@RequestBody planing plan ,@PathVariable ("id") int id,@PathVariable ("idreservation") int idres) throws Exception {
			java.util.List<salle>salles=reposalle.findAll();
			
			  salle	salle1=null;
			  
				for (salle salle : salles) {
					if (salle.getIdsalle()==id)
						salle1=salle;
				     
				}
				if(salle1==null) {
					throw new Exception("salle with id "+id+" does not exist" );
				}
				plan.setIdsalle(salle1);
				
				java.util.List<reservation>reserve=repores.findAll();
				  reservation reserved=null;
				  
					for (reservation reservation : reserve) {
						if(reservation.getIdresrvation()==idres)
							reserved=reservation;
					}
					if(reserved==null) {
						throw new Exception("reservation with id "+idres+" does not exist" );
					}
					
					plan.setIdresrvation(reserved);
					
			planing c=serviceplaning.addplaning(plan, id,idres);
			return new ResponseEntity<planing>(c,HttpStatus.OK);
			
		}
		@GetMapping("/get/{id}/{idsalle}")
		public ResponseEntity<List<planing>> getallplaning(@PathVariable ("id") int id,@PathVariable ("idsalle") int idsalle){
			List<planing>planings=serviceplaning.getidreservation( id,idsalle);
			return new ResponseEntity<List<planing>>(planings,HttpStatus.OK);
					}
		
		@DeleteMapping("delete/{id}")
	    public ResponseEntity<planing> deleteProduit(@PathVariable("id") int id) {
	    	
			repo.deleteById(id);
	        return new ResponseEntity<planing>(HttpStatus.OK);
	    	
	    }
		
		
		}
