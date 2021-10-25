package de.tekup.summer.project.model;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;
@Entity
@AllArgsConstructor
@Getter
@Setter
public class salle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idsalle;
	@Size(min=3,max=30)
	private String nom;
	@Size(min=3,max=30)
	private String ville;
	@Size(min=3,max=30)
	private String  adresse;
	private String image;
	@Size(min=0)
	private int place;
	@Size(min=100)
	private int surface;
	@ManyToOne	
	private category category;
	private String catname;
	
	


	

	public salle() {
		super();
	}






	public salle(String nom, String ville, String adresse, String image, int place, int surface,
			de.tekup.summer.project.model.category category) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
		this.image = image;
		this.place = place;
		this.surface = surface;
		this.category = category;
		this.catname=category.getNomcat();
	}
	
	

}
