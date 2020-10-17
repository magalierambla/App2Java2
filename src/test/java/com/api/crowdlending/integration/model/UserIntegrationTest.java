package com.api.crowdlending.integration.model;

import com.api.crowdlending.model.User;
import com.api.crowdlending.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserIntegrationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    private List<User> expectedUsers = new ArrayList<>();

    @Before
    public void init() {
        User user1 = new User();
        user1.setId(1L);
        user1.setNom("Helton");
        user1.setPrenom("John");

        User user2 = new User();
        user2.setId(1L);
        user2.setNom("Dunkan");
        user2.setPrenom("Mac");

        expectedUsers.add(user1);
        expectedUsers.add(user2);

    }

    @Test
    public void shouldSaveUser() {
        User userToSave = new User();
        userToSave.setId(1L);
        userToSave.setNom("RAMBLA");
        userToSave.setPrenom("Magalie");
        User savedUser = this.userRepository.save(userToSave);

        Optional<User> found = this.userRepository.findById(1L);
        assertThat(found.get()).isEqualTo(savedUser);
    }

    @Test
    public void shouldDisplayUsers() {
        List<User> foundUsers = this.userRepository.findAll();

        assertNotNull(foundUsers);
        assertEquals(foundUsers.size(), 2);

        assertThat(foundUsers.get(0).getNom()).isEqualTo(expectedUsers.get(0).getNom());
        assertThat(foundUsers.get(0).getPrenom()).isEqualTo(expectedUsers.get(0).getPrenom());
        assertThat(foundUsers.get(1).getNom()).isEqualTo(expectedUsers.get(1).getNom());
        assertThat(foundUsers.get(1).getPrenom()).isEqualTo(expectedUsers.get(1).getPrenom());

    }

//    @Test
//    public void shouldDisplayMagalieRAMBLAWhenFindByNomAndPrenom() {
//        User userToSave = new User();
//        userToSave.setId(1L);
//        userToSave.setNom("RAMBLA");
//        userToSave.setPrenom("Magalie");
//        this.userRepository.save(userToSave);
//        Optional<User> foundUser = this.userRepository.findByNomAndPrenom("RAMBLA", "Magalie");
//
//        assertThat(userToSave.getNom()).isEqualTo(foundUser.get().getNom());
//        assertThat(userToSave.getPrenom()).isEqualTo(foundUser.get().getPrenom());
//
//    }
}
