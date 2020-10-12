package com.api.crowdlending.repository;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.MessageModel;

import java.util.List;

@Repository
@Table(name = "messagerie_interne")
public interface MessageRepository extends JpaRepository<MessageModel, Long> {


	 @Query(value = "SELECT  *  FROM  messagerie_interne  WHERE  _token_user_dest=?1", nativeQuery = true)
	 List<MessageModel> findAllMessagesRecusByTokenUser(String tokenUser);


	 @Query(value = "SELECT  *  FROM  messagerie_interne  WHERE  _token_user_exp=?1", nativeQuery = true)
	 List<MessageModel> findAllMessagesEnvoyesByTokenUser(String tokenUser);

}
