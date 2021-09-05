package de.tekup.summer.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@JsonIgnoreType
public class client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min=8,max=8)
	private int telephon;
	@Size(min=3,max=25)
	private String nom;
	@Size(min=3,max=25)
	private String prenom;
	@Size(min=6,max=60)
	private String email;
	@Size(min=6,max=29)
	private String password;
	@Size(min=3,max=32)
	private String adresse;
	@Size(min=2,max=20)
	private String ville;
	@Size(min=3,max=23)
	private String region;
	@OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
	private List<reservation> reserve;
	
	public client(String nom, String prenom, String email, String password, String adresse, String ville, int telephon,
			String region) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.telephon = telephon;
	}



	public client() {
		super();
	}
	
	


}
