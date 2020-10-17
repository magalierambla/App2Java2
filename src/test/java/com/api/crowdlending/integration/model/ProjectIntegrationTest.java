package com.api.crowdlending.integration.model;

import com.api.crowdlending.ApiCrowdlendingApplication;
import com.api.crowdlending.model.Project;
import com.api.crowdlending.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = ApiCrowdlendingApplication.class)
@AutoConfigureMockMvc

@EnableConfigurationProperties
public class ProjectIntegrationTest {
    @Autowired
    private ProjectRepository projectRepository;
 /*   @Autowired
    private TestEntityManager testEntityManager;*/

    private List<Project> expectedProjects = new ArrayList<>();

    @Before
    public void init(){
        Project project1 = new Project();
        project1.setId(1L);
        project1.setNom("Commerce bio");

        expectedProjects.add(project1);

    }
    @Test
    public void shouldSaveProject(){
        Project projectToSave=new Project();
        projectToSave.setId(1L);
        projectToSave.setNom("Commerce bio");
        Project savedProject = this.projectRepository.save(projectToSave);

        Optional<Project> found = this.projectRepository.findById(1L);
        assertThat(found.get()).isEqualTo(savedProject);
    }

    @Test
    public void shouldDisplayProjects(){
        List<Project> foundUsers = this.projectRepository.findAll();

        assertNotNull(foundUsers);
        assertEquals(foundUsers.size(), 1);

        assertThat(foundUsers.get(0).getNom()).isEqualTo(expectedProjects.get(0).getNom());

    }
}
