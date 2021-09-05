package de.tekup.summer.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.summer.project.model.planing;
import de.tekup.summer.project.repository.PlaningRepository;

@Service
public class Serviceplaning {
 @Autowired
 private PlaningRepository RepoPlan;
 
 public planing addplaning(planing plan,int id,int idres) {
		return RepoPlan.save(plan);
	}
}
