package com.api.crowdlending.repository;

import com.api.crowdlending.model.ProjectCategory;
import com.api.crowdlending.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "projects")
public interface ProjectRepository extends JpaRepository<Project, Long> {
	 @Query(value = "SELECT  *  FROM  projects  WHERE  token_user=?1", nativeQuery = true)
	 List<Project> findAllProjectByToken(String tokenUser);

    Optional<Project> findByIdAndProjectCategory(Long id, ProjectCategory projectCategory);
}
