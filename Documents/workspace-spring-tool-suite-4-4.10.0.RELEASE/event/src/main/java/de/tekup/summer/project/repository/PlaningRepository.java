package de.tekup.summer.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.summer.project.model.planing;

public interface PlaningRepository extends JpaRepository<planing , Integer > {

}
