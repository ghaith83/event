package de.tekup.summer.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.summer.project.model.participant;

public interface ParticipantRepsitory extends JpaRepository<participant, Integer>{

}
