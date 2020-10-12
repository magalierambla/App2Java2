package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;



import java.util.List;

@Repository
@Table(name = "fonds_investisseurs_paypal")
public interface FondInvestorRepository extends JpaRepository<FondInvestorModel, Long> {



	List<FondInvestorModel>  findBy_project(Project _project);

	List<FondInvestorModel>  findBy_user(User _user);

	   @Query(value = "SELECT  *  FROM  fonds_investisseurs_paypal  WHERE  token=?1 ", nativeQuery = true)
	   Optional<FondInvestorModel> checkExistFondProjectByToken(String token);

}
