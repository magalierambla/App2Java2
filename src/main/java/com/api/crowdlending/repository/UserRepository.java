package com.api.crowdlending.repository;

import com.api.crowdlending.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<User> findByLogin(String login);

    Optional<User> findByNom(String nom);

    Optional<User> findByNomAndPrenom(String nom, String prenom);
}
