package com.api.crowdlending.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@Table(name = "fonds_investisseurs_paypal",uniqueConstraints={@UniqueConstraint(columnNames ={"token"})})
public class FondInvestorModel implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private String token;

	@Column(nullable = false)
    private String dateCreated;

    @Column(nullable = false)
    private Long timestamp;

    @OneToOne
    @JoinColumn(name = "token_investisseur_project", referencedColumnName = "token")
    private InvestisseursProjectModel _investisseurProject ;


    @OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token")
    private Project _project ;


}
