package de.tekup.summer.project.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
@Data
public class role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 public int id;
 public String name;

public role(String name, de.tekup.summer.project.model.participant participant) {
	super();
	this.name = name;
	
}

 
}
