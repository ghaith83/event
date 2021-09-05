package de.tekup.summer.project.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import de.tekup.summer.project.model.reservation;
@Repository
public interface ReservationERepository extends JpaRepository<reservation, Integer>{
	@Query(value = "select * from reservation u where u.datereservation =?1 and u.idsalle!=?2 ", nativeQuery=true)
	public reservation findByDate(Date datereservation,int idsalle);
}
