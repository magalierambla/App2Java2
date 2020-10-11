package com.api.crowdlending.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StatistiquesChartsDislikeProjectModel implements Serializable{
		
		private  int year;
		
		private  String month;
		
		private String day;
		
		private Integer nbrDislikes ;

}

