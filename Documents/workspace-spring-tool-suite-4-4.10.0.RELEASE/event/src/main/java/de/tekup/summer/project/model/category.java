package de.tekup.summer.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@JsonIgnoreType
public class category {
	@Id
	private String nomcat;
private String image;
private String descrption;
@OneToMany(mappedBy = "category",fetch =FetchType.LAZY,cascade =CascadeType.ALL)
private List<salle> salles;
public category(String nom, String image, String descrption) {
	super();
	this.nomcat = nom;
	this.image = image;
	this.descrption = descrption;
	
}
public category() {
	super();
}


}
