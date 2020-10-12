package com.api.crowdlending.repository;


import java.util.List;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.FavorisProjectUserModel;

@Repository
@Table(name = "favoris_project_user")
public interface FavorisProjectUserRepository extends JpaRepository<FavorisProjectUserModel, Long> {



     @Query(value = "SELECT  *  FROM  favoris_project_user   WHERE  token_user=?1 ", nativeQuery = true)
	 List<FavorisProjectUserModel>  findAllFavorisProjectByUser(String tokenUser);


	 @Query(value = "SELECT  *  FROM  favoris_project_user   WHERE  token_user=?1  AND token_project=?2", nativeQuery = true)
	 List<FavorisProjectUserModel>  findCheckFavorisProject(String tokenUser, String tokenProject);

	 @Transactional
	 @Modifying
	 @Query(value = "DELETE FROM  favoris_project_user    WHERE  token_user=?1  AND token_project=?2", nativeQuery = true)
	 void  deleteFavorisProject(String tokenUser,String tokenProject);

}
