package de.tekup.summer.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class participant {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 public int id;
 public String nom;
 public String prenom;
 public String email;
 public String nomrole;
 @OneToOne
 public role role;
public participant(String nom, String prenom, String email,
		de.tekup.summer.project.model.role role,String nomrole) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.role = role;
	this.nomrole=nomrole;
}

 
}
