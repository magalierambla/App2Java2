package com.api.crowdlending.repository;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.QuestionRepProjectByUserForUserModel;

import java.util.List;

@Repository
@Table(name = "question_rep_project_by_user_for_user")
public interface  QuestionRepProjectByUserForUserRepository extends JpaRepository<QuestionRepProjectByUserForUserModel, Long> {

	//@Query(value = "SELECT  *  FROM  question_rep_project_by_user_for_user  WHERE  token_project=?1 ", nativeQuery = true)
   // List<QuestionRepProjectByUserForUserModel> findByUserForUser(String tokenProject);

}

