package de.tekup.summer.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.summer.project.model.category;
import de.tekup.summer.project.model.salle;
import de.tekup.summer.project.repository.SalleRepository;

@Service
public class ServiceSalle {
	
	private SalleRepository repoSalle;

	public ServiceSalle(SalleRepository repoSalle) {
		super();
		this.repoSalle = repoSalle;
	}

	public List<salle> getAllSalles(){
		return repoSalle.findAll();
		 
	}
	public Optional<salle> getsalle(int id) {
		// TODO Auto-generated method stub
		return repoSalle.findById(id);
	}
	public salle getsalleNom(String nom) {
		salle salleres=null;
		List<salle> salle1=repoSalle.findAll();
		for (salle salle : salle1) {
			if(salle.getNom().equals(nom)) {
				salleres=salle;
			}
			
		}
		return salleres;
	}
	
	public List<salle> getsallebycat(String cat){
		return repoSalle.findByallcat(cat);
	}


}
