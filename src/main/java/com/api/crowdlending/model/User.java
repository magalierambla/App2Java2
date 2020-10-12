package com.api.crowdlending.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.api.crowdlending.enumapp.SexUser;



@Entity
@Table(name = "users",uniqueConstraints={@UniqueConstraint(columnNames ={"login","token","pseudo_name"})})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"date_created"},allowGetters = true)
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
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date_created;
    private String date_update;
    private String pseudo_name;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private SexUser sex;
    private String typeCompte;
	private String photoUser;
    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String newToken) {
		this.token = newToken;
	}

	public Date getDate_naissance() {
			return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
			this.date_naissance = date_naissance;
	}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getCreatedAt() {
        return date_created;
    }

    public void setCreatedAt(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public String getDate_update() {
		return date_update;
	}

	public void setDate_update(String date_update) {
		this.date_update = date_update;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SexUser getSex() {
		return sex;
	}

	public void setSex(SexUser sex) {
		this.sex = sex;
	}

	public String getPhotoUser() {
		return photoUser;
	}

	public void setPhotoUser(String photoUser) {
		this.photoUser = photoUser;
	}

	public Date getDateNaissance() {
		return date_naissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.date_naissance = dateNaissance;
	}

    public String getPseudo_name() {
		return pseudo_name;
	}

	public void setPseudo_name(String pseudo_name) {
		this.pseudo_name = pseudo_name;
	}

}
