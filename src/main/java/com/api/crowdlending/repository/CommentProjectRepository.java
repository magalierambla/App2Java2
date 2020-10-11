package com.api.crowdlending.repository;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;

import java.util.List;

@Repository
@Table(name = "comments_project")
public interface CommentProjectRepository extends JpaRepository<CommentProject, Long> {

	//List<CommentProject>  findBy_project(Project _project);

}
