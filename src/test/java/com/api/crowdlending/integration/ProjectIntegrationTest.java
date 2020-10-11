package com.api.crowdlending.integration;

import com.api.crowdlending.model.Project;
import com.api.crowdlending.model.ProjectCategory;
import com.api.crowdlending.repository.ProjectCategoryRepository;
import com.api.crowdlending.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectIntegrationTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectCategoryRepository projectCategoryRepository;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    @Test
    public void shouldSaveProject() throws ParseException {
        Project projectToSave = new Project();
        projectToSave.setId(1L);
        projectToSave.setNom("Commerce Bio");
        projectToSave.setDescription("Un commerce équitable et Biologique");
        projectToSave.setCreatedDate(format.parse("01-08-2020"));
        projectToSave.setMontantMinimun(200L);
        projectToSave.setDateLimiteCollecte(format.parse("12-11-2020"));

        Optional<ProjectCategory> projectCategory = projectCategoryRepository.findById(1L);
        projectToSave.setProjectCategory(projectCategory.get());


        Project savedProject = this.projectRepository.save(projectToSave);

        Optional<Project> foundProject = this.projectRepository.findByIdAndProjectCategory(1L, projectCategory.get());
        Assertions.assertThat(foundProject.get()).isEqualTo(savedProject);
    }


}
