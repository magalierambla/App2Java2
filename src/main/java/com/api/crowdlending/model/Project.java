package com.api.crowdlending.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.api.crowdlending.enumapp.ValidProject;

@Entity
@Getter
@Setter
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createdDate;
    private String nom;
    private String description;
    private Long montantMinimun;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateLimiteCollecte;
    private String contrePartieProject;
    private String afficheProject;
    @Enumerated(EnumType.STRING)
    private ValidProject validProject;

    private int totalFonds;
    private int totalHearts;
    private int totalLike;
    private int totalDislike;
    private int totalVues;
    private String token;

    @ManyToOne
    @JoinColumn(name = "categorie_project_id")
    private ProjectCategory projectCategory;

}
