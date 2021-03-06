package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.Porte_project;

@Repository
@Table(name = "list_porte_project")
public interface PorteProjectRepository extends JpaRepository<Porte_project, Long> {

	Optional<Porte_project> findByNom(String nomPorte);

}


