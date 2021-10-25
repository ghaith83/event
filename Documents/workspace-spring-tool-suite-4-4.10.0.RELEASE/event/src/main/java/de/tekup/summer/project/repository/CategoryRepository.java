package de.tekup.summer.project.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.summer.project.model.category;
@Repository
public interface CategoryRepository extends JpaRepository<category, String>{


}
