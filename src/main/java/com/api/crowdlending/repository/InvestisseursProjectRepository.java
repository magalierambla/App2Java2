package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;

import java.util.List;

@Repository
@Table(name = "investisseurs_project")
public interface InvestisseursProjectRepository extends JpaRepository<InvestisseursProjectModel, Long> {

	//List<InvestisseursProjectModel>  findBy_project(Project _project);

	@Query(value = "SELECT  *  FROM  investisseurs_project   WHERE  token_project=?1  AND  token_invest=?2 ", nativeQuery = true)
	Optional<InvestisseursProjectModel> check_invest_project(String token_project, String token_invest);

	@Query(value = "SELECT  *  FROM  investisseurs_project  WHERE   token_invest=?1", nativeQuery = true)
    List<InvestisseursProjectModel> findAllContribProjectByToken(String tokenUser);

}
