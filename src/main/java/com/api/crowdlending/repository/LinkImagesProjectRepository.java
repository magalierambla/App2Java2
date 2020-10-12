package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.LinkImageProject;
import com.api.crowdlending.model.Project;

import java.util.List;

@Repository
@Table(name = "list_link_images_project")
public interface LinkImagesProjectRepository extends JpaRepository<LinkImageProject, Long> {


	Optional<LinkImageProject> findByLink(String linkImage);

	List<LinkImageProject>  findBy_project(Project _project);

	@Transactional
    @Modifying
    @Query(value = "DELETE FROM  list_link_images_project    WHERE  id=?1", nativeQuery = true)
    void  deleteLinkImageProject(Long id);

}

