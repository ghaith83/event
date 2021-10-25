package de.tekup.summer.project.model;


import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
@JsonPropertyOrder("")
public class reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idresrvation;
	
	private Date datereservation;
	@OneToOne
	private salle salle;
	private String nomsalle;
	@ManyToOne
	private client client;

	
	
	
	
	





	public reservation() {
		super();
	}










	public reservation(Date datereservation, de.tekup.summer.project.model.salle salle, String idsalle,
			de.tekup.summer.project.model.client client) {
		super();
		this.datereservation = datereservation;
		this.salle = salle;
		this.nomsalle = idsalle;
		this.client = client;
	}










	
	
	
}
