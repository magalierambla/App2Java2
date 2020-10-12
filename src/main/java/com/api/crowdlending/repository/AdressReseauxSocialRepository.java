package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.AdressReseauxSociauxProject;
import com.api.crowdlending.model.Project;

import java.util.List;

@Repository
@Table(name = "adress_reseaux_sociaux_project")
public interface AdressReseauxSocialRepository extends JpaRepository<AdressReseauxSociauxProject, Long> {


	Optional<AdressReseauxSociauxProject> findByKeyMedia(String linkSocial);

	List<AdressReseauxSociauxProject>  findBy_project(Project _project);

	@Transactional
    @Modifying
    @Query(value = "DELETE FROM  adress_reseaux_sociaux_project    WHERE  id=?1", nativeQuery = true)
    void  deleteAdressReseauxSociauxProject(Long id);

}

