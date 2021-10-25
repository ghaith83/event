package de.tekup.summer.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.tekup.summer.project.model.category;
import de.tekup.summer.project.model.salle;
@Repository
public interface SalleRepository extends JpaRepository<salle, Integer>{
	
	@Query(value = "select * from salle u where u.category_nomcat =?1 ", nativeQuery=true)
	public List<salle> findByallcat(String category);
}
