package de.tekup.summer.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import de.tekup.summer.project.model.client;
@Repository
public interface ClientRepository extends JpaRepository<client, Integer>{
public client findAllByEmail(String email);
@Query(value = "select * from client c where c.email=?1 and c.password=?2",nativeQuery = true)
public client findAllByEmailAndPassword(String email,String id);

 
}
