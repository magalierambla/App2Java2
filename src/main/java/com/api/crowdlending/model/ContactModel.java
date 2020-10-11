package com.api.crowdlending.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;



@Entity
@Getter
@Setter
public class ContactModel implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String token;
    
	@Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String date_created;
    
    @Column(nullable = false)
    private String sujet;


	@Column(nullable = true)
    private String date_read;
    
    @Column(nullable = false)
    private Long timestamp_created;
    
    @Column(nullable = true)
    private Long timestamp_read;
    
    @ColumnDefault("0")
    private int statut_read;

	@Column(columnDefinition="TEXT",nullable = false)
    private String description;

}