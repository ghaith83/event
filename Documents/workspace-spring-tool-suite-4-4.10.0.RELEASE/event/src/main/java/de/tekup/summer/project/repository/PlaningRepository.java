package de.tekup.summer.project.repository;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.tekup.summer.project.model.planing;
@Repository
@Transactional
public interface PlaningRepository extends JpaRepository<planing , Integer > {
	
	
	
	@Query(value = "select * from planing u where u.idreservation =?1 and u.idsalle=?2", nativeQuery=true)
	public List<planing>getplans(int idresrvation,int salle);
	@Query(value = "select * from planing u where u.id =?1 ", nativeQuery=true)
	public planing deletePlaningById(int id);
}
