package com.api.crowdlending.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StatistiquesChartsHeartsProjectModel implements Serializable{
		
		private  int year;
		
		private  String month;
		
		private Integer nbrHearts ;
		
		private String day;

}

