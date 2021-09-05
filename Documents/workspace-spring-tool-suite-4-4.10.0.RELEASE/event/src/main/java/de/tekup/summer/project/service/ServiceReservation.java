package de.tekup.summer.project.service;



import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import de.tekup.summer.project.model.reservation;
import de.tekup.summer.project.model.salle;
import de.tekup.summer.project.repository.ReservationERepository;
import de.tekup.summer.project.repository.SalleRepository;
import net.bytebuddy.asm.Advice.Return;



@Service
public class ServiceReservation {

	@Autowired
	ReservationERepository repores;
	
	
	
	public ServiceReservation(ReservationERepository repores) {
		super();
		this.repores = repores;
	}
	public reservation verifReservation(Date datereservation,int idsalle) {
		
		return repores.findByDate(datereservation,idsalle );
		
	}

	public reservation addreservation(reservation res,int id) {
		

		return repores.save(res);
	}
	public Optional<reservation> getReservationById(int id) {
		return repores.findById(id);
	}
	public int sizereservation() {
		return repores.findAll().size();
	}
}
