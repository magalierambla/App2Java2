package com.api.crowdlending.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.api.crowdlending.enumapp.StatutDemandeInvest;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class InvestisseursProjectModel implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	 @Column(nullable = false, updatable = false)
	 private String date_created;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private Long timestamp;

    @Enumerated(EnumType.STRING)
    private StatutDemandeInvest statutDemande ;

    @OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token")
    private Project _project ;


    @Column(nullable = true)
    private String date_update;

}
