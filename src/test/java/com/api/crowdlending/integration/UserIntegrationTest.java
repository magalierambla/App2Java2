package com.api.crowdlending.integration;

import com.api.crowdlending.model.User;
import com.api.crowdlending.repository.UserRepository;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.junit.Assert.*;


// Anotation pour Junit5: @ExtendWith(SpringExtension.class)
// Actuellement on fait les test pour la compatibilité Junit 4
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserIntegrationTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;
    private List<User> expectedUsers = new ArrayList<>();
    private User expectedUser = new User();

    @Before
    public void init(){
        User user1 = new User();
        user1.setId(1L);
        user1.setNom("RAMBLA");
        user1.setPrenom("Magalie");

        User user2 = new User();
        user2.setId(2L);
        user2.setNom("DION");
        user2.setPrenom("Céline");

        expectedUsers.add(user1);
        expectedUsers.add(user2);

        expectedUser.setNom("RAMBLA");
        expectedUser.setPrenom("Magalie");
    }

    @Test
    public void shouldSaveUser(){
        User userToSave = new User();
        userToSave.setId(1L);
        userToSave.setNom("Helton");
        userToSave.setPrenom("John");

        User savedUser = this.userRepository.save(userToSave);

        Optional<User> foundUser = this.userRepository.findByNom("Helton");

        Assertions.assertThat(foundUser.get()).isEqualTo(savedUser);
    }

    @Test
    public void shouldDisplayUsers(){
        List<User> usersFromDb = this.userRepository.findAll();

        assertNotNull(usersFromDb);
        assertEquals(usersFromDb.get(0).getNom(), expectedUsers.get(0).getNom());
        assertEquals(usersFromDb.get(0).getPrenom(), expectedUsers.get(0).getPrenom());
        assertEquals(usersFromDb.get(0).getId(), expectedUsers.get(0).getId());
        //Do same assertEquals for the second user
        assertEquals(usersFromDb.get(1).getNom(), expectedUsers.get(1).getNom());
        assertEquals(usersFromDb.get(1).getPrenom(), expectedUsers.get(1).getPrenom());
        assertEquals(usersFromDb.get(1).getId(), expectedUsers.get(1).getId());
    }

    @Test
    public void shouldDisplayRAMBLAandMagalieWhenNomIsRAMBLAandPrenomIsMagalie(){
        Optional<User> userFromDb = this.userRepository.findByNomAndPrenom("RAMBLA", "Magalie");

        assertTrue(userFromDb.isPresent());
        assertNotNull(userFromDb.get());
        assertEquals(userFromDb.get().getNom(), expectedUser.getNom());
        assertEquals(userFromDb.get().getPrenom(), expectedUser.getPrenom());

    }



}
