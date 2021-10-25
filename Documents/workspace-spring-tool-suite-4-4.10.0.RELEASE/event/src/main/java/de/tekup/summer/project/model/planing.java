package de.tekup.summer.project.model;


import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;
@Entity
@Data
@Transactional
@JsonIgnoreType
public class planing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false ,updatable = false)
	private int id;
	
	private LocalTime heuredebut;
	private LocalTime heurefin;
	private String nomTache;
	private String detailTache;
	
	private String nompart;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idsalle" )
    private salle idsalle;
	
	@OneToOne(cascade = CascadeType.REMOVE )
	@JoinColumn(name = "idreservation")
	private reservation idresrvation;

	public planing(LocalTime heuredebut, LocalTime heurefin, String nomTache, String detailTache,
			de.tekup.summer.project.model.participant participant, String nompart, salle idsalle,
			reservation idresrvation) {
		super();
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.nomTache = nomTache;
		this.detailTache = detailTache;
		this.nompart = nompart;
		this.idsalle = idsalle;
		this.idresrvation = idresrvation;
	}

	public planing() {
		super();
	}
	
	
}
