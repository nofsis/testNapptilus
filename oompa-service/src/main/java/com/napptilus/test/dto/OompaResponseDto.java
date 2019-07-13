package com.napptilus.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OompaResponseDto {
	
	private Integer id;
	
	private String name ;
	
	private int age;
	
	private String job;
	
	private double height;
	
	private double weight;
	
	private String description;

}
