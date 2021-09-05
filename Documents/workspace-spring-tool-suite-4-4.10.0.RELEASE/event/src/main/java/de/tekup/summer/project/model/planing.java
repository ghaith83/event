package de.tekup.summer.project.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class planing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdPlaning;
	@OneToOne
    private salle idsalle;
	private LocalTime heuredebut;
	private LocalTime heurefin;
	private String nomTache;
	private String detailTache;
	@OneToOne
	private reservation idresrvation;
}
