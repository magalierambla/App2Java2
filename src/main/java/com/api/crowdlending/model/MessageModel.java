package com.api.crowdlending.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "messagerie_interne")  
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class MessageModel implements Serializable{

	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String bodyMessage;
    
    @Column(nullable = false)
    private String dateCreated;
    
    @Column(nullable = false)
    private Long timestamp;
    

    @Column(nullable = true)
    private String _tokenProject ;
    
    @Column(nullable = false)
    private String _nomUserExp;   
    

    @Column(nullable = false)
    private String _nomUserDest;
    
    @Column(nullable = false)
    private String _photoUserExp;   
    

    @Column(nullable = false)
    private String _photoUserDest;
    
    @Column(nullable = false)
    private String _tokenUserExp;   
    

    @Column(nullable = false)
    private String _tokenUserDest;
	
	@Column(nullable = false)
    private String statutExp;
	
	@Column(nullable = false)
    private String statutDest;
	
    @Column(nullable = true)
	 private Long timestampConsultation;
	 
    @Column(nullable = true)
	 private String dateConsultation;


}
