package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.CategoryProject;

@Repository
@Table(name = "list_category_project")
public interface CategoryProjectRepository extends JpaRepository<CategoryProject, Long> {


	Optional<CategoryProject> findByNom(String nomCategorie);

}
