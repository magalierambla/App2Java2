package com.api.crowdlending.model;

import com.api.crowdlending.enumapp.SexeUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Getter
@Setter
public class User implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String login;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    private String pseudo;

    @Enumerated(EnumType.STRING)
    private SexeUser sexe;

    private String typeCompte;

	private String photo;

    private Date dateNaissance;

    private String password;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
