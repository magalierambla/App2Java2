package com.api.crowdlending.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StatistiquesChartsUsersModel implements Serializable{
	
	private  String year;
	
	private Integer nbrUsers ;

}
