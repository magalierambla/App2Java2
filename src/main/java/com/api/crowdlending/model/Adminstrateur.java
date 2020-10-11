package com.api.crowdlending.model;

import com.api.crowdlending.enumapp.SexeUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"date_created"},allowGetters = true)
@Getter
@Setter
public class Adminstrateur implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date_created;

    @Column(nullable = true)
    private String date_update;

    @Column(nullable = false)
    private String pseudoName;


    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private SexeUser sexe;

    @Column(nullable = false)
    private String typeCompte;

	private String photoUser;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;



    @Column(nullable = false)
    private String token;

}
