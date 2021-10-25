package de.tekup.summer.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.summer.project.model.planing;
import de.tekup.summer.project.model.reservation;
import de.tekup.summer.project.model.salle;
import de.tekup.summer.project.repository.PlaningRepository;
import de.tekup.summer.project.repository.ReservationERepository;
import de.tekup.summer.project.repository.SalleRepository;
import net.bytebuddy.asm.Advice.Return;

@Service
public class Serviceplaning {
 @Autowired
 private PlaningRepository RepoPlan;
 @Autowired
 private PlaningRepository reservei;
 
 public planing addplaning(planing plan,int id,int idres) {
		return RepoPlan.save(plan);
	}
 public List<planing>allpalning(){
	 return RepoPlan.findAll();
 }
 
 public List<planing>getidreservation(int id , int idsalle ){
	 List<planing>plan=reservei.getplans(id, idsalle);
	 return plan;
 }
 
 public void deletepalning(int p){
	 RepoPlan.deletePlaningById(p);
 }
}
