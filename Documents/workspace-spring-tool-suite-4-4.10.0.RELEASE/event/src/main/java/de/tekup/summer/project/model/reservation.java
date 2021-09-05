package de.tekup.summer.project.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
	private int idsalle;
	@ManyToOne
	  @JoinTable(name = "reservation_client",
      joinColumns = @JoinColumn(name ="idresrvation"),
      inverseJoinColumns = @JoinColumn(name = "idclient"))
	private client client;
	
	
	
	
	





	public reservation() {
		super();
	}










	public reservation(Date datereservation, de.tekup.summer.project.model.salle salle, int idsalle,
			de.tekup.summer.project.model.client client) {
		super();
		this.datereservation = datereservation;
		this.salle = salle;
		this.idsalle = idsalle;
		this.client = client;
	}










	
	
	
}
