package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.StatutProject;

@Repository
@Table(name = "list_statut_project")
public interface StatutProjectRepository extends JpaRepository<StatutProject, Long> {


	Optional<StatutProject> findByNom(String nomPorte);

}
