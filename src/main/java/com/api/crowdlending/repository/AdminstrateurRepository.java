package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.Adminstrateur;

@Repository
@Table(name = "adminstrateurs")
public interface AdminstrateurRepository extends JpaRepository<Adminstrateur, Long> {


	Optional<Adminstrateur> findByLogin(String nomLogin);


	 @Query(value = "SELECT  *  FROM  adminstrateurs  WHERE  login=?1  AND  password=?2", nativeQuery = true)
	 Adminstrateur getUserByEmailAndPassword(String login, String password);

	 @Query(value = "SELECT  *  FROM  adminstrateurs  WHERE  login=?1 ", nativeQuery = true)
	 Adminstrateur checkExistMailUser(String login);

	  @Query(value = "SELECT  *  FROM  adminstrateurs  WHERE  token=?1 ", nativeQuery = true)
      Optional<Adminstrateur> checkExistUserByToken(String token);



}
