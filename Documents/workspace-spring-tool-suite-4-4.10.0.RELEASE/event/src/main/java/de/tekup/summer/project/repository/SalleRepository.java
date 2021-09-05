package de.tekup.summer.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.summer.project.model.salle;
@Repository
public interface SalleRepository extends JpaRepository<salle, Integer>{
}
