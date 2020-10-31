package com.api.crowdlending.repository;

import com.api.crowdlending.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT COUNT(*) AS nbr_items FROM  users", nativeQuery = true)
    Long countItem();

    @Query(value = "SELECT  *  FROM  users  WHERE  login=?1  AND  password=?2", nativeQuery = true)
    User getUserByEmailAndPassword(String login, String password);

    @Query(value = "SELECT  *  FROM  users  WHERE  login=?1 ", nativeQuery = true)
    User checkExistMailUser(String login);

    @Query(value = "SELECT  *  FROM  users  WHERE  token=?1 ", nativeQuery = true)
    Optional<User> checkExistUserByToken(String token);

    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM users WHERE YEAR( date_created ) = YEAR( NOW( ) )", nativeQuery = true)
    int countNbrUsersForYearCurrent();

    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -1 YEAR ) )", nativeQuery = true)
    int countNbrUsersForLast1Year();

    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -2 YEAR ) )", nativeQuery = true)
    int countNbrUsersForLast2Year();

    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -3 YEAR ) )", nativeQuery = true)
    int countNbrUsersForLast3Year();

    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -4 YEAR ) )", nativeQuery = true)
    int countNbrUsersForLast4Year();


    //Optional<User> findByNomAndPrenom(String rambla, String magalie);

    Optional<User> findByLogin(String login);
}
